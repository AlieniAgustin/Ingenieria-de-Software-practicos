package org.example;

/**
 * Solución implementada siguiendo el enfoque visto en clase teórica de Ingeniería de Software,
 * aplicando Test-Driven Development (TDD) al problema de determinar si un año es bisiesto.
*/

public class App {
    
    /**
    public static boolean isLeapYear(int year){
        return true;
    }
    */

    /**
    *  esto es antes de permitir que sea divisible por 100 si tambien lo es por 400
    public static boolean isLeapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0);
    }
    */
    
    /**
     * 
    public static boolean isLeapYear(int year){
        if(year % 4 == 0){
            return !(year % 100 == 0) || (year % 400 == 0);
            //ya que tenemos la implicacion (year % 100 == 0) => (year % 400 == 0)
            //las implicaciones las podemos expresar como disyunciones, p => q === !p v q 
        }
        return false;
    }
    */

    //refactorizo lo de arriba y agrego excepcion (ahorro pasos)
    public static boolean isLeapYear(int year){
        if(year < 1582)
            throw new IllegalArgumentException();

        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
}
