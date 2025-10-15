package testing.partition.practico.ejercicio5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBoundedQueue{

  @Test 
  public void baseTest(){
    BoundedQueue q = new BoundedQueue(3);
    q.enQueue(1);
    q.enQueue(2);
    Object o = q.deQueue();
    assertEquals(1, o);
    assertFalse(q.isEmpty());
    assertFalse(q.isFull());
  }

  @Test 
  public void constructorShouldIllegalArgumentExceptionForNegativeCapacity(){
    assertThrows(IllegalArgumentException.class, () -> new BoundedQueue(-1));
  }

  @Test 
  public void queueWithZeroCapacity(){
    BoundedQueue q = new BoundedQueue(0);
    assertThrows(IllegalStateException.class, () -> q.enQueue(2));
    assertThrows(IllegalStateException.class, () -> q.deQueue());
    assertTrue(q.isEmpty());
    assertTrue(q.isFull());
  }

  @Test 
  public void enqueueShouldNullPointerExceptionForNullElement(){
    BoundedQueue q = new BoundedQueue(3);
    assertThrows(NullPointerException.class, () -> q.enQueue(null));
    q.enQueue(2);
    q.enQueue(3);
    Object o = q.deQueue();
    assertEquals(2,o);
    assertFalse(q.isEmpty());
    assertFalse(q.isFull());
  }
  
  @Test 
  public void enqueueInNoEmptyAndNoFullQueue(){
    BoundedQueue q = new BoundedQueue(3);
    q.enQueue(1);
    q.enQueue(2);
    Object o = q.deQueue();
    assertEquals(1,o);
    assertFalse(q.isEmpty());
    assertFalse(q.isFull());
  }

  @Test 
  public void enqueueShouldIllegalStateExceptionForFullQueue(){
    BoundedQueue q = new BoundedQueue(2);
    q.enQueue(1);
    q.enQueue(2);
    assertThrows(IllegalStateException.class, () -> q.enQueue(3));
    Object o = q.deQueue();
    assertEquals(1,o);
    assertFalse(q.isEmpty());
    assertFalse(q.isFull());
  }

  @Test 
  public void dequeueShouldIllegalStateExceptionForEmptyQueue(){
    BoundedQueue q = new BoundedQueue(2);
    assertThrows(IllegalStateException.class, () -> q.deQueue());
  }

  @Test 
  public void dequeueInFullQueue(){
    BoundedQueue q = new BoundedQueue(1);
    q.enQueue(1);
    Object o = q.deQueue();
    assertEquals(1,o);
    assertTrue(q.isEmpty());
    assertFalse(q.isFull());
  }

  @Test 
  public void queueIsEmpty(){
    BoundedQueue q = new BoundedQueue(1);
    assertTrue(q.isEmpty());
  }

  @Test 
  public void queueIsNotEmptyBecauseQueueIsFull(){
    BoundedQueue q = new BoundedQueue(1);
    q.enQueue(1);
    assertFalse(q.isEmpty());
    assertTrue(q.isFull());
  }

  @Test 
  public void queueIsNotFullBecauseQueueIsEmpty(){
    BoundedQueue q = new BoundedQueue(1);
    assertFalse(q.isFull());
    assertTrue(q.isEmpty());
  }

  @Test 
  public void QueueIsFullAndQueueIsNotEmpty(){
    BoundedQueue q = new BoundedQueue(1);
    q.enQueue(1);
    assertTrue(q.isFull());
    assertFalse(q.isEmpty());
  }

}

