package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Solución implementada siguiendo el enfoque visto en clase teórica de Ingeniería de Software,
 * aplicando Test-Driven Development (TDD) al problema de determinar si un año es bisiesto.
*/

public class AppTest {

    /**
     * primero escribo un test que encuentre el primer error,
     * que en este caso, es que la clase App no tiene el metodo isLeapYear
     *
     
    @Test 
    public void testValidLeapYear(){
        assertTrue(App.isLeapYear(2020));
    }
    */
    
    /**
     * escribo el menor codigo necesario para que no haya mas fallas,
     *en este caso es una clase estatica que con ese metodo retorne true 
    
    @Test 
    public void testValidLeapYear(){
        assertTrue(App.isLeapYear(2020));
    }
    

    public static class App{
        public static boolean isLeapYear(int n){
            return true;
        }
    }
   */


  /**
   * ahora refactorizo: aclaro quien es arrange, act y assert en test
   * y llevo isLeapYear a la clase app
  

    @Test 
    public void testValidLeapYear(){
        int year = 2020; //arrange 
        boolean isLeapYear = App.isLeapYear(year); //act 
        assertTrue(isLeapYear); //assert 
    }

  */


  /**
   * busco error, cuando year = 2019 no debe ser bisiesto
  */
    @Test 
    public void testValidLeapYear1(){
        int year = 2020; //arrange 
        boolean isLeapYear = App.isLeapYear(year); //act 
        assertTrue(isLeapYear); //assert 
    }

    @Test 
    public void testInvalidLeapYear1(){
        int year = 2019; //arrange
        boolean isLeapYear = App.isLeapYear(year); //act 
        assertFalse(isLeapYear); //assert
    }

    /**
     * busco error, cuando year = 1900 no debe ser bisiesto,
     * ya que si bien es divisible por 4, tambien lo es por 100 
    */
    @Test 
    public void testInvalidLeapYear2(){
        int year = 1900; //arrange
        boolean isLeapYear = App.isLeapYear(year); //act 
        assertFalse(isLeapYear); //assert
        //error, ya que debo agregar en el metodo isLeapYear que no sea divisible por 1900
        //lo de abajo es suponiendo que solucione lo del comentario anterior
    }

    /**
     * busco error, cuando year = 2000 debe ser bisiesto,
     * ya que si bien es divisible por 4 y por 100, tambien lo es por 400
    */
    @Test 
    public void testValidLeapYear2(){
        int year = 2000; //arrange 
        boolean isLeapYear = App.isLeapYear(year); //act 
        assertTrue(isLeapYear); //assert 
        //error, ya que debo permitir que sea divisible por 4 y por 100 solo si tmb lo es por 400 
        //lo de abajo es suponiendo que solucione lo del comentario anterior
    }

    /**
     *busco error, cuando year = 1581 debo obtener excepcion,
     * ya que es un anio anterior al calendario gregoriano empieza en 1582
    */
    @Test 
    public void testExceptionLeapYear(){
        int year = 1581; //arrange 
        assertThrows(IllegalArgumentException.class, () -> App.isLeapYear(year)); //act y assert
    }
  
}
