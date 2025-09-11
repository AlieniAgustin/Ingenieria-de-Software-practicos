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
    char[][] classicMatrix = {
      {'B','B','B','B','B','B','B','B'},
      {'B','B','B','B','W','B','B','B'},
      {'B','B','B','W','W','B','B','B'},
      {'B','B','B','B','B','B','B','B'}
    }; 

    char[][] bocaMatrix = {
      {'B','B','B','B','B','B','B','B'},
      {'B','B','B','B','Y','B','B','B'},
      {'B','B','B','Y','Y','B','B','B'},
      {'B','B','B','B','B','B','B','B'}
    };

    char[][] riverMatrix = {
      {'R','R','R','R','R','R','R','R'},
      {'R','R','R','R','W','R','R','R'},
      {'R','R','R','W','W','R','R','R'},
      {'R','R','R','R','R','R','R','R'}
    };
    
    return Stream.of(
      Arguments.of(
        new StandardLife(),
        classicMatrix,
        new ClassicColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBWWBBB\nBBBWWBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBWWBBB\nBBBWWBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      ),  
      Arguments.of(
        new HighLife(),
        classicMatrix,
        new ClassicColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBWWBBB\nBBBWWBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBWWBBB\nBBBWWBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new SeedLife(),
        classicMatrix,
        new ClassicColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBBBWBB\nBBBBBWBB\nBBBWWBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBBWBWB\nBBBWBBWB\nBBBBBWBB\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new StandardLife(),
        bocaMatrix,
        new BocaColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBYYBBB\nBBBYYBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBYYBBB\nBBBYYBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      ),  
      Arguments.of(
        new HighLife(),
        bocaMatrix,
        new BocaColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBYYBBB\nBBBYYBBB\nBBBBBBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBYYBBB\nBBBYYBBB\nBBBBBBBB\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new SeedLife(),
        bocaMatrix,
        new BocaColorScheme(),
        List.of(
          "Generation 2: \n4 8\nBBBBBBBB\nBBBBBYBB\nBBBBBYBB\nBBBYYBBB\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nBBBBBBBB\nBBBBYBYB\nBBBYBBYB\nBBBBBYBB\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new StandardLife(),
        riverMatrix,
        new RiverColorScheme(),
        List.of(
          "Generation 2: \n4 8\nRRRRRRRR\nRRRWWRRR\nRRRWWRRR\nRRRRRRRR\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nRRRRRRRR\nRRRWWRRR\nRRRWWRRR\nRRRRRRRR\n" //esperado tras 2 generaciones 
        )
      ),  
      Arguments.of(
        new HighLife(),
        riverMatrix,
        new RiverColorScheme(),
        List.of(
          "Generation 2: \n4 8\nRRRRRRRR\nRRRWWRRR\nRRRWWRRR\nRRRRRRRR\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nRRRRRRRR\nRRRWWRRR\nRRRWWRRR\nRRRRRRRR\n" //esperado tras 2 generaciones 
        )
      ),
      Arguments.of(
        new SeedLife(),
        riverMatrix,
        new RiverColorScheme(),
        List.of(
          "Generation 2: \n4 8\nRRRRRRRR\nRRRRRWRR\nRRRRRWRR\nRRRWWRRR\n", //esperado tras 1 generacion 
          "Generation 3: \n4 8\nRRRRRRRR\nRRRRWRWR\nRRRWRRWR\nRRRRRWRR\n" //esperado tras 2 generaciones 
        )
      )
    );
  }

  /**
   * Test parametrizado: se ejecuta una vez por cada Arguments.of(...) definido arriba 
   */
  @ParameterizedTest 
  @MethodSource("provideGamesAndExpectations")
  void testMultipleGenerations(LifeRule rule, char[][] input, ColorScheme colorScheme, List<String> expectedGenerations){
    GameOfLife game = new GameOfLife(input,rule,colorScheme);

    //recorro la lista de estados separados
    for(String expected : expectedGenerations){
      game.nextGeneration();
      assertEquals(expected,game.toString());
    }
  }

}
