package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AppTest {

  // Método proveedor de implementaciones de PrimeValidator
  static Stream<PrimeValidator> primeValidators() {
    return Stream.of(
        new SequentialPrimeValidator(),
        new RecursivePrimeValidator()
    );
  }

  /*
   * Con esto, cada test se ejecuta dos veces: una con SequentialPrimeValidator y otra con RecursivePrimeValidator. 
   * Asi podemos asegurarnos q todas las implementaciones pasan por los mismos casos de prueba sin repetir codigo
   */

  @ParameterizedTest
  @MethodSource("primeValidators")
  public void testGetFirstTwoPrimes(PrimeValidator validator){
    PrimeGenerator generator = new PrimeGenerator(validator);
    generator.getFirstNPrimes(2); 
  }

  @ParameterizedTest
  @MethodSource("primeValidators")
  public void testGetFirstFourPrimes(PrimeValidator validator){
    PrimeGenerator generator = new PrimeGenerator(validator);
    generator.getFirstNPrimes(4); 
  }

  @ParameterizedTest
  @MethodSource("primeValidators")
  public void testGetZeroPrimes(PrimeValidator validator){
    PrimeGenerator generator = new PrimeGenerator(validator);
    generator.getFirstNPrimes(0); 
  }

  @ParameterizedTest
  @MethodSource("primeValidators")
  public void testGetFirstNPrimesException(PrimeValidator validator){
    PrimeGenerator generator = new PrimeGenerator(validator);
    assertThrows(IllegalArgumentException.class, () -> generator.getFirstNPrimes(-1));
  }
}
  /**
   * antes de parametrizar los tests 
  @Test 
  public void testGetFirstTwoPrimes(){
    PrimeGenerator generator = new PrimeGenerator(new SequentialPrimeValidator());
    generator.getFirstNPrimes(2); 
  }

  @Test 
  public void testGetFirstFourPrimes(){
    PrimeGenerator generator = new PrimeGenerator(new RecursivePrimeValidator());
    generator.getFirstNPrimes(4); 
  }

  @Test 
  public void testGetZeroPrimes(){
    PrimeGenerator generator = new PrimeGenerator(new SequentialPrimeValidator());
    generator.getFirstNPrimes(0); 
  }

  @Test 
  public void testGetFirstNPrimesException(){
    PrimeGenerator generator = new PrimeGenerator(new RecursivePrimeValidator());
    assertThrows(IllegalArgumentException.class, () -> generator.getFirstNPrimes(-1));
  }
  */


