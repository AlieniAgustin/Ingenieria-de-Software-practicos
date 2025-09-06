package org.example;

import java.util.List;
import java.util.ArrayList;

public class PrimeGenerator {
   
  private List<Integer> primes;
  private PrimeValidator primeValidator;
  private OutputStrategy output;

  public PrimeGenerator(PrimeValidator primeValidator, OutputStrategy output){
    primes = new ArrayList<>();
    this.primeValidator = primeValidator;
    this.output = output;
  }

  /**
   * @pre n >= 0
   * @post imprime por pantalla los primeros n numeros primos 
   */
  public void getFirstNPrimes(int n){

    if(n < 0){
      throw new IllegalArgumentException();
    }else if(n == 0){
      showOutput("");
    }else{
      primes.add(2); //el dos es el primer numero primo 
      int currentNumber = 3;

      while(primes.size() < n){
        if(isPrime(currentNumber)){
          primes.add(currentNumber);
        }

        currentNumber += 2;
      }

      String output = listToString();
      showOutput(output);
    }
  }

  private boolean isPrime(int n){
    return primeValidator.isPrime(n);
  }

  private String listToString(){
    String output = "";
    for(int prime : primes)
      output += prime + " ";
    return output;
  }

  private void showOutput(String output){
    this.output.showOutput(output);
  }
 
}
