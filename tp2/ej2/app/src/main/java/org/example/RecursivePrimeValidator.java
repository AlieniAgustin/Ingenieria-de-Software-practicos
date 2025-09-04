package org.example;

public class RecursivePrimeValidator implements PrimeValidator{

  /**
   * @pre n >= 1
   * @post retorna true sii n es un numero primo
   */
  public boolean isPrime(int n){
    if(n < 1)
      throw new IllegalArgumentException();

    if(n == 1)
      return false;

    return isPrime(n,(int) Math.sqrt(n));
  }

  /**
   * @pre n >= 2
   * @post va llevando los computos parciales para saber si n es primo 
   */
  private boolean isPrime(int n, int m){
    if(m == 1)
      return true;

    return (n % 2 != 0) && isPrime(n,m-1);
  }
}
