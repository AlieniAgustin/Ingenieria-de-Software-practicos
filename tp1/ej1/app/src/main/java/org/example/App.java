// Este archivo implementa la solución del problema FizzBuzz
// siguiendo la metodología Test-Driven Development (TDD).
// Se generan los casos de prueba primero y luego se implementa
// la lógica para que todos los tests pasen.
package org.example;

public class App {
    /**
     * primera implementacion de kata, donde retorno siempre 1
    public static String kata(int n){
        return "1";
    }
    */

    /**
     * retorno algo distinto a n solo si n es divisible por 3
    public static String kata(int n){
        String answer = "" + n;
        if(n % 3 == 0)
            answer = "Fizz";
        return answer; 
    }
    */

    /**
     * todavia no tengo en cuenta cuando n es divisible por 3 y 5
    public static String kata(int n){
        String answer = "" + n;
        if(n % 3 == 0)
            answer = "Fizz";
        else if(n % 5 == 0)
            answer = "Buzz";
        return answer; 
    }
    */
    
    /**
     * todavia no tengo en cuenta cuando n < 1 || n > 100
     *
    public static String kata(int n){
        String answer = "" + n;
        if(n % 3 == 0 && n % 5 == 0)
            answer = "FizzBuzz";
        else if(n % 3 == 0)
            answer = "Fizz";
        else if(n % 5 == 0)
            answer = "Buzz";
        return answer; 
    }
    */

    //primer kata, sin las nuevas reglas del stage 2 
    public static String kata(int n){

        if(n < 1 || n > 100)
            throw new IllegalArgumentException();

        String answer = "" + n;
        if(n % 3 == 0 && n % 5 == 0)
            answer = "FizzBuzz";
        else if(n % 3 == 0)
            answer = "Fizz";
        else if(n % 5 == 0)
            answer = "Buzz";
        return answer; 
    }
    

    /**
     * agregue las nuevas reglas cuando el numero contiene 3 o 5
     */
    public static String kata2(int n){
        if(n < 1 || n > 100)
            throw new IllegalArgumentException();

        String intToString = String.valueOf(n);
        String answer = "";
        if(n % 3 == 0) 
            answer += "Fizz";
        if(intToString.contains("3"))
            answer += "Fizz";
        if(n % 5 == 0)
            answer += "Buzz";
        if(intToString.contains("5"))
            answer += "Buzz";

        return answer; 
    }
    
}
