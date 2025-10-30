package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUniqueStack{

  @Test 
  public void pushTest(){
    UniqueStack<Integer> stack = new UniqueStack<>();
    assertTrue(stack.isEmpty());
    stack.push(2);
    stack.push(3);
    assertEquals(2, stack.size());
    assertEquals("[2, 3]", stack.toString());
    assertThrows(IllegalArgumentException.class, () -> stack.push(2));
    assertThrows(NullPointerException.class, () -> stack.push(null));
  }

  @Test 
  public void popTest(){
    UniqueStack<Integer> stack = new UniqueStack<>();
    assertThrows(IllegalStateException.class, () -> stack.pop());
    stack.push(2);
    stack.push(3);
    int removed = stack.pop();
    assertEquals(removed, 3);
    assertEquals(1, stack.size());
  }

  @Test 
  public void peekTest(){
    UniqueStack<Integer> stack = new UniqueStack<>();
    assertThrows(IllegalStateException.class, () -> stack.peek());
    stack.push(2);
    stack.push(3);
    int top = stack.peek();
    assertEquals(top, 3);
    assertEquals(2, stack.size());
  }


}

