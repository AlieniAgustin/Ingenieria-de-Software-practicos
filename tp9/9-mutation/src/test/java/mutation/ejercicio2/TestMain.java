package mutation.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestMain{

  @Test 
  public void sumWhenAllElementsOfxAreZero(){
    //alcanza al mutante, pero no produce infeccion,
    //ya que el estado interno del programa no difiere
    //del estado cuando no se ejecuta el mutante 
    int[] x = {0,0,0,0};
    int currentSum = Main.sum(x);
    int expectedSum = 0;
    assertEquals(expectedSum,currentSum);
  }

  @Test 
  public void sumWhenInxThereAreNumbersAndTheirOpposites(){
    //alcanza al mutante, produce infeccion ya que 
    //el estado interno del programa cambia con el 
    //estado sin mutante, pero no hay propagacion 
    //ya que el valor final es el mismo que sin el mutante
    int[] x = {3, -2, 2, -3};
    int currentSum = Main.sum(x);
    int expectedSum = 0;
    assertEquals(expectedSum,currentSum);
  }

  @Test 
  public void testSum(){
    //alcanza al mutante, produce infeccion y permite 
    //matar al mutante, ya que se obtiene un valor 
    //distinto al original
    int[] x = {2,3,5};
    int currentSum = Main.sum(x);
    int expectedSum = 10;
    assertEquals(expectedSum,currentSum);
  }
}

