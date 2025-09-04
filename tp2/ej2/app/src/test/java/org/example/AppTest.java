package org.example;

/**
 * primero se resuelve el problema de isPrime con TDD
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  
  /**
   * Creo una clase App que siempre retorne true en el isPrime 
   */
  @Test 
  public void testIsPrime1(){
    assertTrue(App.isPrime(2));
  }

  /**
   * Va a dar error porque hasta el momento isPrime siempre retorna true 
   */
  @Test 
  public void testIsPrime2(){
    assertFalse(App.isPrime(6));
  }

  /**
   * va a fallar porque hasta el momento isPrime no tira excepcion cuando el numero es menor que 1 
   */
  @Test 
  public void testIsPrime3(){
    assertThrows(IllegalArgumentException.class, () -> App.isPrime(0));
  }

  //A PARTIR DE AQUI, LOS TESTS DEL STRATEGY
  @Test 
  public void testPrimeServiceRecursive(){
    PrimeService service = new PrimeService(new RecursivePrimeValidator());
    assertTrue(service.check(2));
    assertFalse(service.check(6));
  }

  @Test 
  public void testPrimeServiceSequential(){
    PrimeService service = new PrimeService(new SequentialPrimeValidator());
    assertTrue(service.check(2));
    assertFalse(service.check(6));
  }

  @Test
  public void testSetPrimeValidator(){
    PrimeService service = new PrimeService(new RecursivePrimeValidator());
    assertTrue(service.check(7));
    assertTrue(service.check(41));
    service.setPrimeValidator(new SequentialPrimeValidator());
    assertTrue(service.check(7));
    assertTrue(service.check(41));
  }
}
