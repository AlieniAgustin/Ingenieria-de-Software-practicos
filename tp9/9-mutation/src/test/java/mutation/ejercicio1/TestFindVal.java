package mutation.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestFindVal{

  @Test 
  public void findValInEmptyArray(){
    int[] numbers = {};
    int value = 2;
    int currentLastIndex = FindVal.findVal(numbers,value);
    int expectedLastIndex = -1;
    assertEquals(expectedLastIndex,currentLastIndex);
  }

  @Test 
  public void valIsNotInNumbers(){
    //ademas, alcanza al mutante, pero no produce infeccion
    int[] numbers = {2, 4};
    int value = 6;
    int currentLastIndex = FindVal.findVal(numbers,value);
    int expectedLastIndex = -1;
    assertEquals(expectedLastIndex,currentLastIndex);
  }

  @Test 
  public void valAppearsMoreThanOnceInNumbers(){
    //alcanza al mutante, produce infeccion, pero no propagacion
    int[] numbers = {2, 2};
    int value = 2;
    int currentLastIndex = FindVal.findVal(numbers,value);
    int expectedLastIndex = 1;
    assertEquals(expectedLastIndex,currentLastIndex);
  }

  @Test 
  public void valIsTheFirstElementOfNumbers(){
    //alcanza al mutante, produce infeccion y propagacion 
    //ya que la salida final es distinta a la original
    //este es el test que encuentra, y por ende, mata al mutante
    int[] numbers = {7, 8, 9};
    int value = 7;
    int currentLastIndex = FindVal.findVal(numbers,value);
    int expectedLastIndex = 0;
    assertEquals(expectedLastIndex,currentLastIndex);
  }

}
