package org.example;

public class PrimeService{
  private PrimeValidator validator;

  public PrimeService(PrimeValidator validator){
    this.validator = validator;
  }

  public void setPrimeValidator(PrimeValidator validator){
    this.validator = validator;
  }

  public boolean check(int n){
    return validator.isPrime(n);
  }
}
