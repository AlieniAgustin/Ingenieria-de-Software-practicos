package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * INVARIANT: Stack where there are no repeated elements
 */
public class UniqueStack<E>{

  private List<E> stack;

  /**
   * PRECONDITION: true
   * POSTCONDITION: the stack is created 
   */
  public UniqueStack(){
    stack = new ArrayList<>();

    assert stack != null;
    assert isEmpty();

    assert repOk();
  }

  /**
   * PRECONDITION: item != null && !stack.contains(item)
   * POSTCONDITION: item is stacked
   */
  public void push(E item){
    if (item == null)
      throw new NullPointerException();

    if (stack.contains(item))
      throw new IllegalArgumentException();

    int oldSize = size();
    stack.add(item);
    int newSize = size();

    assert newSize == oldSize + 1;
    assert stack.get(newSize - 1).equals(item);

    assert repOk();
  }

  /**
   * PRECONDITION: !isEmpty()
   * POSTCONDITION: removes the last stacked element and returns it 
   */
  public E pop(){
    if (isEmpty())
      throw new IllegalStateException();

    int oldSize = size();
    E removed = stack.remove(oldSize - 1);
    int newSize = size();

    assert newSize == oldSize - 1;
    assert !stack.contains(removed);

    assert repOk();

    return removed;
  }

  /**
   * PRECONDITION: !isEmpty()
   * POSTCONDITION: returns the last stacked element 
   */
  public E peek(){
    if (isEmpty())
      throw new IllegalStateException();

    int oldSize = size();
    E top = stack.get(oldSize - 1);
    int newSize = size();

    assert newSize == oldSize;
    assert stack.contains(top);

    assert repOk();

    return top;
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns true if the stack is empty 
   */
  public boolean isEmpty(){
    assert repOk();

    return size() == 0;
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: returns the size of the stack
   */
  public int size(){
    assert repOk();

    return stack.size();
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns the stack representation as a string
   */
  public String toString(){
    assert repOk();

    return stack.toString();
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: the invariant 
   */
  public boolean repOk(){
    Set<E> alreadySeen = new HashSet<>();

    for(E e : stack){
      if(alreadySeen.contains(e))
        return false;

      alreadySeen.add(e);
    }
    return true;
  }

}
