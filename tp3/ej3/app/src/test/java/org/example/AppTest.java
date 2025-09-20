package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.colorScheme.*;
import org.example.gameOfLifeVariant.*; 
import org.example.gameOfLife.*;
import org.example.display.*;

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

  @Test 
  public void testBlackAndWhiteAliveDisplay(){
    System.out.println("test black and white alive display");
    ColorScheme colorScheme = new BocaColorScheme();
    GameOfLifeVariant variant = new InmigrationVariant();
    char[][] input = {
      {'w','b','w','w','w'},
      {'w','w','y','w','w'},
      {'b','b','y','w','w'},
      {'w','w','w','w','w'},
      {'w','w','w','w','w'}
    };

    GameOfLife game = new GameOfLife(input,colorScheme,variant);
    Observer black = new BlackAliveDisplay(game);
    //Observer white = new WhiteAliveDisplay(game);
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
    game.nextGeneration();
  }

  @Test 
  public void testStatsDisplay(){
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    ColorScheme colorScheme = new BocaColorScheme();
    GameOfLifeVariant variant = new InmigrationVariant();
    char[][] input = {
      {'w','b','w','w','w'},
      {'w','w','y','w','w'},
      {'b','b','y','w','w'},
      {'w','w','w','w','w'},
      {'w','w','w','w','w'}
    };

    GameOfLife game = new GameOfLife(input,colorScheme,variant);
    Observer stats = new StatsDisplay(game);
    String expected = "Display 1: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 2: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 3: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 4: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 5: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 6: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 7: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 8: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 9: \n";
    expected += "Number of cells: 25\nNumber of living cells: 4\nNumber of dead cells: 21\n";
    expected += "Average number of live cells: 4.88\nAverage number of dead cells: 20.11";
    game.nextGeneration();
    expected += System.lineSeparator();
    assertEquals(expected,outContent.toString());
    System.setOut(originalOut);
  }

  @Test 
  public void testGenerationRulesDisplay(){
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    ColorScheme colorScheme = new BocaColorScheme();
    GameOfLifeVariant variant = new InmigrationVariant();
    char[][] input = {
      {'w','b','w','w','w'},
      {'w','w','y','w','w'},
      {'b','b','y','w','w'},
      {'w','w','w','w','w'},
      {'w','w','w','w','w'}
    };

    GameOfLife game = new GameOfLife(input,colorScheme,variant);
    Observer stats = new GenerationRulesDisplay(game);
    String expected = "Display 1: \n";
    expected += "Last gen: Alive: 0.12, Born: 0.08, Died: 0.08\n";
    expected += "Average: Alive: 0.12, Born: 0.08, Died: 0.08\n";
    game.nextGeneration();
    
    
    expected += "Display 2: \n";
    expected += "Last gen: Alive: 0.12, Born: 0.08, Died: 0.08\n";
    expected += "Average: Alive: 0.12, Born: 0.08, Died: 0.08";
    game.nextGeneration();
    
    /*
    expected += "Display 3: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 4: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 5: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 6: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 7: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 8: \n";
    expected += "Number of cells: 25\nNumber of living cells: 5\nNumber of dead cells: 20\n";
    expected += "Average number of live cells: 5\nAverage number of dead cells: 20\n";
    game.nextGeneration();

    expected += "Display 9: \n";
    expected += "Number of cells: 25\nNumber of living cells: 4\nNumber of dead cells: 21\n";
    expected += "Average number of live cells: 4.88\nAverage number of dead cells: 20.11";
    game.nextGeneration();
    */
    expected += System.lineSeparator();
    assertEquals(expected,outContent.toString());
    System.setOut(originalOut);
  }

}
