package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AppTest {

/**
 * Genera los parametros para el test. 
 * Cada Arguments.of(...) representa un caso de prueba:
 *  -una implementacion de LifeRule.
 *  -un tablero inicial.
 *  -una lista con los strings esperados para las siguientes generaciones
 */
  private static Stream<Arguments> provideGamesAndExpectations(){
    char[][] initialMatrix = {
      {'.','.','.','.','.','.','.','.'},
      {'.','.','.','.','*','.','.','.'},
      {'.','.','.','*','*','.','.','.'},
      {'.','.','.','.','.','.','.','.'}
    }; 
    
    return Stream.of(
      Arguments.of(
        new StandardLife(),
        initialMatrix,
        List.of(
          "Generation 2: \n4 8\n........\n...**...\n...**...\n........\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\n........\n...**...\n...**...\n........\n" //esperado tras 2 generaciones 
        )
      ),  
      Arguments.of(
        new HighLife(),
        initialMatrix,
        List.of(
          "Generation 2: \n4 8\n........\n...**...\n...**...\n........\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\n........\n...**...\n...**...\n........\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new SeedLife(),
        initialMatrix,
        List.of(
          "Generation 2: \n4 8\n........\n.....*..\n.....*..\n...**...\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\n........\n....*.*.\n...*..*.\n.....*..\n" //esperado tras 2 generaciones 
        )
      )
    );
  }

  /**
   * Test parametrizado: se ejecuta una vez por cada Arguments.of(...) definido arriba 
   */
  @ParameterizedTest 
  @MethodSource("provideGamesAndExpectations")
  void testMultipleGenerations(LifeRule rule, char[][] input, List<String> expectedGenerations){
    GameOfLife game = new GameOfLife(input,rule);

    //recorro la lista de estados separados
    for(String expected : expectedGenerations){
      game.nextGeneration();
      assertEquals(expected,game.toString());
    }
  }

}
