package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  
  @Test 
  public void testToString1(){
    char[][] m = {
      {'.','.','.','.','.','.','.','.'},
      {'.','.','.','.','*','.','.','.'},
      {'.','.','.','*','*','.','.','.'},
      {'.','.','.','.','.','.','.','.'}
    };
    GameOfLife game = new GameOfLife(m);
    String expectedString = "Generation 1: \n4 8\n";
    expectedString += "........\n....*...\n...**...\n........\n";
    assertEquals(expectedString,game.toString());
  }

  @Test 
  public void testNextGeneration1(){
    char[][] m = {
      {'.','.','.','.','.','.','.','.'},
      {'.','.','.','.','*','.','.','.'},
      {'.','.','.','*','*','.','.','.'},
      {'.','.','.','.','.','.','.','.'}
    };
    GameOfLife game = new GameOfLife(m);
    game.nextGeneration();
    String expectedString = "Generation 2: \n4 8\n";
    expectedString += "........\n...**...\n...**...\n........\n";
    assertEquals(expectedString,game.toString());
  }
  
}
