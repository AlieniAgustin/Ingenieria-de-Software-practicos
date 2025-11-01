package org.example;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * INVARIANT: 
 * currentFloor >= 1 && currentFloor <= maxFloor && maxFloor >= 1 && state != null &&
 * elevatorMovementRequests contains valid floors 
 */
public class Elevator{

  private int currentFloor;
  private ElevatorState state;
  private int maxFloor;
  private Deque<Integer> elevatorMovementRequests;

  /**
   * PRECONDITION: maxFloor >= 1
   * POSTCONDITION: create an idle elevator with the given max floor 
   */
  public Elevator(int maxFloor){
    if(maxFloor < 1)
      throw new IllegalArgumentException();

    this.currentFloor = 1;
    this.state = ElevatorState.IDLE;
    this.maxFloor = maxFloor;

    this.elevatorMovementRequests = new ArrayDeque<>();

    assert this.currentFloor == 1;
    assert this.state == ElevatorState.IDLE;
    assert this.maxFloor == maxFloor;
    assert this.elevatorMovementRequests.isEmpty();

    assert repOk();
  }

  /**
   * PRECONDITION: state != ElevatorState.OUT_OF_SERVICE && 1 <= floor <= maxFloor
   * POSTCONDITION: add the elevator movement request 
   */
  public void callToFloor(int floor){
    if(state == ElevatorState.OUT_OF_SERVICE)
      throw new IllegalStateException();

    if(floor < 1 || floor > maxFloor)
      throw new IllegalArgumentException();

    int oldSize = elevatorMovementRequests.size();

    elevatorMovementRequests.offer(floor);
    int newSize = elevatorMovementRequests.size();

    assert !elevatorMovementRequests.isEmpty();
    assert elevatorMovementRequests.peekLast() == floor;
    assert newSize == oldSize + 1;

    assert repOk();
  }

  /**
   * PRECONDITION: !elevatorMovementRequest.isEmpty() && state == ElevatorState.IDLE
   * POSTCONDITION: start moving the elevator to the corresponding floor
   */
  public void move(){
    if(elevatorMovementRequests.isEmpty())
      throw new IllegalStateException();

    if(state != ElevatorState.IDLE)
      throw new IllegalStateException();

    int futureFloor = elevatorMovementRequests.peek();

    if(futureFloor > currentFloor)
      state = ElevatorState.MOVING_UP;
    else if(futureFloor < currentFloor)
      state = ElevatorState.MOVING_DOWN;

    //if futureFloor == currentFloor => state == ElevatorState.IDLE 
    assert (futureFloor != currentFloor) || (state == ElevatorState.IDLE);
    //if futureFloor < currentFloor => state == ElevatorState.MOVING_DOWN 
    assert (futureFloor >= currentFloor) || (state == ElevatorState.MOVING_DOWN);
    //if futureFloor > currentFloor => state == ElevatorState.MOVING_UP 
    assert (futureFloor <= currentFloor) || (state == ElevatorState.MOVING_UP);

    assert repOk();
  }

  /**
   * PRECONDITION:
   * state != ElevatorState.OUT_OF_SERVICE
   * !elevatorMovementRequest.isEmpty()
   * elevatorMovementRequests.peek() == currentFloor => state == ElevatorState.IDLE 
   * elevatorMovementRequests.peek() < currentFloor => state == ElevatorState.MOVING_DOWN 
   * elevatorMovementRequests.peek() > currentFloor => state == ElevatorState.MOVING_UP 
   * 
   * POSTCONDITION: the elevator finishes moving to the corresponding floor 
   */
  public void stop(){
    if(state == ElevatorState.OUT_OF_SERVICE)
      throw new IllegalStateException();

    if(elevatorMovementRequests.isEmpty())
      throw new IllegalStateException();

    /**
     * RECORDAR FORMULAS:
     * p => q === not p or q
     * not (p => q) === not (not p or q) === p and not q
     */
    int futureFloor = elevatorMovementRequests.peek();

    if((futureFloor == currentFloor) && (state != ElevatorState.IDLE))
      throw new IllegalStateException();

    if((futureFloor < currentFloor) && (state != ElevatorState.MOVING_DOWN))
      throw new IllegalStateException();

    if((futureFloor > currentFloor) && (state != ElevatorState.MOVING_UP))
      throw new IllegalStateException();

    int oldSize = elevatorMovementRequests.size();

    elevatorMovementRequests.poll();
    int newSize = elevatorMovementRequests.size();

    currentFloor = futureFloor;

    state = ElevatorState.IDLE;

    assert newSize == oldSize - 1;
    assert state == ElevatorState.IDLE;
    assert currentFloor == futureFloor;

    assert repOk();
  }

  /**
   * PRECONDITION: state != ElevatorState.OUT_OF_SERVICE
   * POSTCONDITION: the elevator is taken out of service and all elevator movement requests are removed
   */
  public void setOutOfService(){
    if(state == ElevatorState.OUT_OF_SERVICE)
      throw new IllegalStateException();

    state = ElevatorState.OUT_OF_SERVICE;
    elevatorMovementRequests.clear();

    assert state == ElevatorState.OUT_OF_SERVICE;
    assert elevatorMovementRequests.isEmpty();

    assert repOk();
  }

  /**
   * PRECONDITION: state != ElevatorState.OUT_OF_SERVICE
   * POSTCONDITION: returns the current floor 
   */
  public int getCurrentFloor(){
    if(state == ElevatorState.OUT_OF_SERVICE)
      throw new IllegalStateException();

    assert repOk();
    return currentFloor;
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns the elevator state 
   */
  public ElevatorState getElevatorState(){
    assert repOk();

    return state;
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns true if the invariant is true
   */
  public boolean repOk(){
    if(currentFloor < 1 || currentFloor > maxFloor || maxFloor < 1 || state == null || elevatorMovementRequests == null)
      return false;

    if(state == ElevatorState.OUT_OF_SERVICE && !elevatorMovementRequests.isEmpty())
      return false;

    for(int floor : elevatorMovementRequests)
      if(floor < 1 || floor > maxFloor)
        return false;

    return true;
  }

}

