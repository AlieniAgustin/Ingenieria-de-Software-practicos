package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

class AppTest {

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
        "Recursive, File, -1"
    })
    void testGetFirstNPrimes(String validatorType, String outputType, int n) throws IOException{
        PrimeValidator validator = validatorType.equals("Sequential") 
            ? new SequentialPrimeValidator() 
            : new RecursivePrimeValidator();

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


