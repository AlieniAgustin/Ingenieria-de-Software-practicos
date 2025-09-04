package org.example;

public class App {

  public static boolean isPrime(int n){
    //idea de algoritmo isPrime: 
    //si n es 1, retorno false
    //sino, recorro los numeros del intervalo entero [2,sqrt n], si alguno de ellos divide a n, entonces no es primo
    //en caso de terminar ese recorrido, n es primo 
    //la complejidad es O(sqrt n)
    
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
