package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestElevator{


  //YA SE QUE ES UN TEST DE MIERDA, PERO ME CANSE DE HACER TANTOS TESTS LA RE CON DE MI MADRE. Y TODAVIA ME QUEDA VOLVER A HACER LOS PRACTICOS AYUDA 
  @Test 
  public void test1(){
    Elevator elevator = new Elevator(5);
    elevator.callToFloor(2);
    elevator.callToFloor(5);
    elevator.callToFloor(1);
    elevator.move();
    assertEquals(ElevatorState.MOVING_UP,elevator.getElevatorState());
    elevator.stop();
    assertEquals(2,elevator.getCurrentFloor());
    assertEquals(ElevatorState.IDLE,elevator.getElevatorState());
    elevator.move();
    assertEquals(ElevatorState.MOVING_UP,elevator.getElevatorState());
    elevator.stop();
    assertEquals(5,elevator.getCurrentFloor());
    assertEquals(ElevatorState.IDLE,elevator.getElevatorState());
    elevator.move();
    assertEquals(ElevatorState.MOVING_DOWN,elevator.getElevatorState());
    elevator.stop();
    assertEquals(1,elevator.getCurrentFloor());
    assertEquals(ElevatorState.IDLE,elevator.getElevatorState());
    elevator.setOutOfService();
    assertEquals(ElevatorState.OUT_OF_SERVICE,elevator.getElevatorState());
  }


}

