package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    /**
     * va a dar un error porque nisiquiera existe la clase StringCalculator, 
     * ni mucho menos su metodo.
     * lo soluciono creando una clase en este archivo, con el metodo constante
     * luego refactorizo utilizando StringCalculator.java
     */
    @Test 
    public void testNumbersEmpty(){
        StringCalculator s = new StringCalculator();
        int expectedAdd = 0;
        String numbers = ""; //arrange 
        int add = s.add(numbers); //act
        assertEquals(expectedAdd,add); //assert 
    }
    
    /**
     * va a dar error porque aunque le pase un solo numero, me dara siempre 0,
     * retornando 0, 1 o 2 dependiendo el string 
     */
    @Test 
    public void testIdentity(){
        StringCalculator s = new StringCalculator();
        int expectedAdd = 1;
        String numbers = "1";
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }

    /**
     * va a dar un error porque todavia no sabe que hacer cuando le 
     * paso una cadena que no es vacio ni 0 ni 1 ni 2
     */
    @Test 
    public void testSimpleSum1(){
        StringCalculator s = new StringCalculator();
        int expectedAdd = 3;
        String numbers = "1,2";
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }

    /**
     * va a dar un error porque todavia no captura excepcion cuando 
     * los strings no vienen en la forma esperada
     */
    @Test 
    public void testIllegalArgument1(){
        StringCalculator s = new StringCalculator();
        String numbers = "1,";
        assertThrows(IllegalArgumentException.class, () -> s.add(numbers));
    }

    @Test 
    public void testIllegalArgument2(){
        StringCalculator s = new StringCalculator();
        String numbers = ",2";
        assertThrows(IllegalArgumentException.class, () -> s.add(numbers));
    }

    /**
     * va a dar un error porque todavia no sabe que hacer cuando vienen mas de 2
     * numeros en el parametro
     */
    @Test 
    public void testSimpleSum2(){
        StringCalculator s = new StringCalculator();
        String numbers = "3,2,5,0";
        int expectedAdd = 10;
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }
   
    /**
     * va a dar un error porque no estamos considerando la posibilidad de que 
     * los numeros tengan 2 o mas digitos
     */
    @Test 
    public void testSimpleSum3(){
        StringCalculator s = new StringCalculator();
        String numbers = "5,10";
        int expectedAdd = 15;
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }

    /**
     * pense que iba a dar un error porque creia que leia primero  y el siguiente n (por ende excepcion),
     * pero lee \n todo junto, entonces no hay errores, funciona bien xd 
     */
    @Test 
    public void testLineBreak1(){
        StringCalculator s = new StringCalculator();
        String numbers = "1\n2,3";
        int expectedAdd = 6;
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }
 

    /**
     * solo un test mas  
     */
    @Test 
    public void testLineBreak2(){
        StringCalculator s = new StringCalculator();
        String numbers = "1,\n";
        assertThrows(IllegalArgumentException.class, () -> s.add(numbers));
    }
  
    /**
     * va a fallar porque por el momento solo se aceptan delimitadores default, 
     * que son ',' y '/n'
    */
    @Test 
    public void testNoDefaultDelimiter(){
        StringCalculator s = new StringCalculator();
        String numbers = "//;\n2;3";
        int expectedAdd = 5;
        int add = s.add(numbers);
        assertEquals(expectedAdd,add);
    }
    
    /**
     * va a fallar porque hasta el momento no se tira una excepcion especial 
     * para numeros negativos 
     */
    @Test 
    public void testNegativesNotAllowed1(){
        StringCalculator s = new StringCalculator();
        String numbers = "1,3,4,-123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> s.add(numbers));
        assertEquals("negatives not allowed: [-123]", exception.getMessage());
    }

    /**
     * va a fallar porque hasta el momento no se tira una excepcion especial 
     * cuando hay varios numeros negativos
     */
    @Test 
    public void testNegativesNotAllowed2(){
        StringCalculator s = new StringCalculator();
        String numbers = "1,2,-10,3,4,555,-100,0,-20,0,2";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> s.add(numbers));
        assertEquals("negatives not allowed: [-10, -100, -20]", exception.getMessage());
    }
  

    /**
    public class StringCalculator{
        public int add(String numbers){
            return 0;
        }
    }*/

}
