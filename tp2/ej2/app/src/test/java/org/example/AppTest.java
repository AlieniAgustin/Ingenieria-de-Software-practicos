package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

class AppTest {

    //tests solo con ejecucion (archivo e imprimir)
    @ParameterizedTest
    @CsvSource({
        "Sequential, Console, 2",
        "Sequential, Console, 4",
        "Sequential, Console, 0",
        "Sequential, Console, -1",
        "Sequential, File, 2",
        "Sequential, File, 4",
        "Sequential, File, 0",
        "Sequential, File, -1",
        "Recursive, Console, 2",
        "Recursive, Console, 4",
        "Recursive, Console, 0",
        "Recursive, Console, -1",
        "Recursive, File, 2",
        "Recursive, File, 4",
        "Recursive, File, 0",
        "Recursive, File, -1",
        "Optimized, Console, 2",
        "Optimized, Console, 4",
        "Optimized, Console, 0",
        "Optimized, Console, -1",
        "Optimized, File, 2",
        "Optimized, File, 4",
        "Optimized, File, 0",
        "Optimized, File, -1"
    })
    void testGetFirstNPrimes(String validatorType, String outputType, int n) throws IOException{ 

        PrimeValidator validator;
        if(validatorType.equals("Sequential"))
            validator = new SequentialPrimeValidator();
        else if(validatorType.equals("Recursive"))
            validator = new RecursivePrimeValidator();
        else 
            validator = new OptimizedPrimeValidator();

        OutputStrategy output = outputType.equals("Console") 
            ? new ConsoleOutputStrategy() 
            : new FileOutputStrategy(java.nio.file.Files.createTempFile("primes", ".txt").toString());

        PrimeGenerator generator = new PrimeGenerator(validator, output);

        if (n < 0) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> generator.getFirstNPrimes(n));
        } else {
            generator.getFirstNPrimes(n); // solo ejecutar
        }
    }

    //tests verificando output con Mock
    @ParameterizedTest 
    @CsvSource({
        "Sequential, 2, '2 3 '",
        "Sequential, 4, '2 3 5 7 '",
        "Sequential, 0, ''",
        "Recursive, 2, '2 3 '",
        "Recursive, 4, '2 3 5 7 '",
        "Recursive, 0, ''",
        "Optimized, 2, '2 3 '",
        "Optimized, 4, '2 3 5 7 '",
        "Optimized, 0, ''"
    })
    void testGetFirstNPrimesWithMock(String validatorType, int n, String expectedOutput) {
      // Elegir la implementación de PrimeValidator
      PrimeValidator validator = validatorType.equals("Sequential")
          ? new SequentialPrimeValidator()
          : new RecursivePrimeValidator();

      OutputStrategy output = new MockOutputStrategy();
      PrimeGenerator generator = new PrimeGenerator(validator, output);

      generator.getFirstNPrimes(n);

      // Verificamos que el output sea el esperado
      Assertions.assertEquals(expectedOutput, ((MockOutputStrategy) output).getLastOutput());
  }   

  //para probar excepcion con n < 0
  @ParameterizedTest 
  @CsvSource({
      "Sequential, -1",
      "Recursive, -1",
      "Optimized, -1"
  })
  void testGetFirstNPrimesWithMockException(String validatorType, int n) {
      PrimeValidator validator = validatorType.equals("Sequential")
          ? new SequentialPrimeValidator()
          : new RecursivePrimeValidator();

      OutputStrategy output = new MockOutputStrategy();
      PrimeGenerator generator = new PrimeGenerator(validator, output);

      Assertions.assertThrows(IllegalArgumentException.class, () -> generator.getFirstNPrimes(n));
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


