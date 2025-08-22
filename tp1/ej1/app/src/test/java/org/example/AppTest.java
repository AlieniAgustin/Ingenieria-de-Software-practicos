// Este archivo implementa la solución del problema FizzBuzz
// siguiendo la metodología Test-Driven Development (TDD).
// Se generan los casos de prueba primero y luego se implementa
// la lógica para que todos los tests pasen.

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    /**
     * primero soluciono el error creando una clase estatica con el metodo kata 
     * que retorna siempre  
    
    @Test 
    public void testKata1(){
        int n = 1; //arrange
        String answer = App.kata(n); //act
        assertEquals(answer,"1"); //assert 
    }

    public static class App{
        
        public static String kata(int n){
            return "1";
        }
    }
    Luego para refactorizar creo la clase App en App.java
    */

    @Test 
    public void testKata1(){
        int n = 1; //arrange
        String answer = App.kata(n); //act 
        assertEquals(answer,"1"); //assert 
    }

    //va a fallar en un principio, porque retorna siempre 1, y debe dar Fizz 
    @Test 
    public void testKata2(){
        int n = 3; //arrange 
        String answer = App.kata(n); //act 
        assertEquals(answer,"Fizz");
    }

    //va a fallar en un principio, porque retorna 10 en lugar de Buzz 
    @Test 
    public void testKata3(){
        int n = 10; //arrange 
        String answer = App.kata(n); //act 
        assertEquals(answer,"Buzz");
    }

    //va a fallar en un principio, porque matchea primero con divisible por 3 y retorna Fizz
    //en lugar de FizzBuzz
    @Test 
    public void testKata4(){
        int n = 15; 
        String answer = App.kata(n);
        assertEquals(answer, "FizzBuzz");
    }

    //va a fallar porque todavia no hay captura de excepciones para n fuera de rango
    @Test 
    public void testKata5(){
        int n = 0;
        int m = 101;
        assertThrows(IllegalArgumentException.class, () -> App.kata(n));
        assertThrows(IllegalArgumentException.class, () -> App.kata(m));
    }

    //va a fallar porque todavia no agregue las nuevas condiciones de fizz y buzz 
    //cuando el numero contiene 3 o 5 
    @Test 
    public void test2ndKata1(){
        int n = 53;
        int m = 35;
        //String answer = App.kata(n); lo comento porque ahora uso un nuevo kata con otras reglas
        String answer1 = App.kata2(n);
        String answer2 = App.kata2(m);
        assertEquals(answer1,"FizzBuzz");
        assertEquals(answer2,"FizzBuzzBuzz");
    }

}
