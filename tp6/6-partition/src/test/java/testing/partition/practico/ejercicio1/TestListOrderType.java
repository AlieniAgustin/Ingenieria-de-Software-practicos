package testing.partition.practico.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class TestListOrderType{

  @Test 
  public void testListWithAllItsElementsEqual(){
    List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(2);
    list.add(2);
    ListOrderType orderType = new ListOrderType();
    assertTrue(orderType.processList(list));
  }

  @Test
  public void purelyAscendingListTest(){
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(4);
    list.add(5);
    ListOrderType orderType = new ListOrderType();
    assertTrue(orderType.processList(list));
  }

  @Test
  public void purelyDescendingListTest(){
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(2);
    list.add(2);
    list.add(0);
    ListOrderType orderType = new ListOrderType();
    assertTrue(orderType.processList(list));
  }

  @Test
  public void purelyUnorderedListTest(){
    List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(3);
    list.add(5);
    list.add(4);
    list.add(7);
    list.add(0);
    ListOrderType orderType = new ListOrderType();
    assertTrue(orderType.processList(list));
  }

}


