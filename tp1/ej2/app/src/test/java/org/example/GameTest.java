package org.example;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    /**
     *  va a dar error porque no existe la clase Game, y 
     *  por ende, no tiene un metodo score. 
     *  creo una clase Game que tenga el metodo 
     *  y que retorne siempre 0
     *  luego refactorizo
     */
    @Test 
    public void testNoRolls(){
        int expectedScore = 0;
        Game game = new Game();
        int score = game.score();
        assertEquals(score, expectedScore);
    }

    /**
     * antes de crear Game.java
    public class Game{
        public Game(){}

        public int score(){
            return 0;
        }
    }
    */

    /**
     * va a dar error porque no existe el metodo roll aun, 
     * y ademas de ello, sin importar si ejecute o no roll, 
     * siempre score retorna 0 hasta el momento.
     * creo el metodo roll con su logica, y en un atributo 
     * currentScore llevo la puntuacion hasta el momento 
     * para que score retorne el valor de dicho atributo
     */
    @Test
    public void testRollsAndScore1(){
        int expectedScore = 5;
        Game game = new Game();
        game.roll(2); game.roll(3);
        assertEquals(game.score(), expectedScore);
    }

    /**
     * va a dar un error porque no captura la excepcion,
     * no se deberia poder ejecutar roll con una cantidad de 
     * pinos mayor a 10 o menor que cero
     */
    @Test 
    public void testRollsIllegalArgument1(){
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> game.roll(11));
    }

    /**
     * va a dar un resultado inesperado, porque hasta el momento 
     * no controlo que en el segundo tiro del frame solo puedo llegar 
     * a tirar como maximo la cantidad de bolos que quedaron del 
     * primer tiro del frame 
     */
    @Test 
    public void testRollsIllegalArgument2(){
        Game game = new Game();
        game.roll(6);
        assertThrows(IllegalStateException.class, () -> game.roll(5));
    }

    /**
     * va a dar un error porque hasta el momento no tiene en 
     * cuenta la cantidad de cuadros posibles, por ende, deja que 
     * se hagan los tiros que se quiera.
     * la solucion es llevar un contador de cuadros, que incrementa 
     * cada dos tiros
     */
    @Test 
    public void testGameEndsAfterTenFrames(){
        Game game = new Game();
        game.roll(1); game.roll(0); //1st frame 
        game.roll(1); game.roll(0); //2nd frame
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);  
        game.roll(1); game.roll(0);  
        game.roll(1); game.roll(0);  
        assertThrows(IllegalStateException.class, () -> game.roll(1));
    }

    
  /**
   * va a dar un error porque hasta el momento no se estan teniendo en 
   * cuenta las condiciones para tener un spare
   */
    @Test 
    public void testSpare1(){
        int expectedScore = 14; // 10 de los tiros de frame 1, 2 del siguiente tiro,
                                // donde esa misma cantidad tambien es la modificacion por el spare 
        Game game = new Game();
        game.roll(5);
        game.roll(5);
        game.roll(2);
        assertEquals(game.score(), expectedScore);
    }

    @Test 
    public void testSpare2(){
        int expectedScore = 20;
        Game game = new Game();
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0); 
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0); 
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0);
        game.roll(1); game.roll(0); 
        game.roll(1); game.roll(0);
        game.roll(5); game.roll(5);
        //hubo un spare en el ultimo frame, asi que tengo que 
        //permitir que se haga un tiro mas
        game.roll(1);
        assertEquals(game.score(), expectedScore);
    }
    
    /**
     * otra prueba de spare en ultimo frame 
     */
    @Test 
    public void testSpare3(){
        int expectedScore = 26;
        Game game = new Game();
        game.roll(6); game.roll(4); //11 por bonus 
        game.roll(1); game.roll(0); //1
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(0); game.roll(0);
        game.roll(6); game.roll(4); //14 por bonus 
        game.roll(4);
        assertEquals(game.score(), expectedScore);
    }
    
    /**
     * va a dar error porque todavia no considero 
     * los bonus del strike
     */
      @Test 
      public void testStrike1(){
          int expectedScore = 22;
          Game game = new Game();
          game.roll(10); //16 por bonus de strike 
          game.roll(2); 
          game.roll(4);
          assertEquals(game.score(), expectedScore);
      }

      /**
       * no dara lo esperado, porque todavia no considero 
       * el caso de un strike en el ultimo frame 
       */
      @Test 
      public void testStrike2(){
          int expectedScore = 15;
          Game game = new Game();
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(0); game.roll(0);
          game.roll(10);  //15 por el bonus de strike 
          game.roll(3); game.roll(2);
          assertEquals(game.score(), expectedScore);
      }
      
      @Test 
      public void testStrike3(){
          int expectedScore = 95;
          Game game = new Game();
          game.roll(10); //13 
          game.roll(1); game.roll(2); //3 
          game.roll(5); game.roll(5); //11
          game.roll(1); game.roll(0); //1 
          game.roll(7); game.roll(3); //20
          game.roll(10); //20
          game.roll(0); game.roll(10); //12
          game.roll(2); game.roll(1); //3 
          game.roll(0); game.roll(0); //0
          game.roll(10);  //12
          game.roll(1); game.roll(1); 
          assertEquals(game.score(), expectedScore);
      }
    

}
