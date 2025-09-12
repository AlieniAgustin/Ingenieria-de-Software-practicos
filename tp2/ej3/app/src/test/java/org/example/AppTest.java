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
    char[][] classicMatrix1 = {
      {'B','B','B','B','B','B','B','B'},
      {'B','B','B','B','R','B','B','B'},
      {'B','B','B','R','W','B','B','B'},
      {'B','B','B','B','B','B','B','B'}
    }; 

     char[][] classicMatrix2 = {
      {'B','B','B','B','B','B','B','B'},
      {'B','B','B','B','W','B','B','B'},
      {'B','B','B','G','R','B','B','B'},
      {'B','B','B','B','B','B','B','B'}
    };
    return Stream.of(
      Arguments.of(
        classicMatrix1,
        new ClassicColorScheme(),
        new InmigrationVariant(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBRRBBB\nBBBRWBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBRRBBB\nBBBRWBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      ),
       Arguments.of(
        classicMatrix2,
        new ClassicColorScheme(),
        new QuadLifeVariant(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBYWBBB\nBBBGRBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBYWBBB\nBBBGRBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      )
    );
  }

  /**
   * Test parametrizado: se ejecuta una vez por cada Arguments.of(...) definido arriba 
   */
  @ParameterizedTest 
  @MethodSource("provideGamesAndExpectations")
  void testMultipleGenerations(char[][] input, ColorScheme colorScheme, GameOfLifeVariant variant, List<String> expectedGenerations){
    GameOfLife game = new GameOfLife(input,colorScheme,variant);

    //recorro la lista de estados separados
    for(String expected : expectedGenerations){
      game.nextGeneration();
      assertEquals(expected,game.toString());
    }
  }

}
