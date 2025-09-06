package org.example;

import java.util.List;
import java.util.ArrayList;

public class PrimeGenerator {
   
  private List<Integer> primes;
  private PrimeValidator primeValidator;

  public PrimeGenerator(PrimeValidator primeValidator){
    primes = new ArrayList<>();
    this.primeValidator = primeValidator;
  }

  /**
   * @pre n >= 0
   * @post imprime por pantalla los primeros n numeros primos 
   */
  public void getFirstNPrimes(int n){

    if(n < 0){
      throw new IllegalArgumentException();
    }else if(n == 0){
      System.out.println("");
    }else{
      primes.add(2); //el dos es el primer numero primo 
      int currentNumber = 3;

      while(primes.size() < n){
        if(isPrime(currentNumber)){
          primes.add(currentNumber);
        }

        currentNumber += 2;
      }

      String output = generateOutput();
      System.out.println(output);
    }
  }

  private boolean isPrime(int n){
    return primeValidator.isPrime(n);
  }

  private String generateOutput(){
    String output = "";
    for(int prime : primes)
      output += prime + " ";
    return output;
  }
 
}
