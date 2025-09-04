package org.example;

public class SequentialPrimeValidator implements PrimeValidator{

  public boolean isPrime(int n){
    if(n < 1) 
      throw new IllegalArgumentException();

    if(n == 1) 
      return false; 

    int limit = (int) Math.sqrt(n);
    for(int i = 2; i <= limit; i++)
      if(n % i == 0)
        return false; 

    return true; 
  }

}
