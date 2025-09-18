package org.example.app;

import org.example.gameOfLife.GameOfLife;
import org.example.colorScheme.*; 
import org.example.gameOfLifeVariant.*; 
import org.example.display.*;

public class Main{

  public static void main(String[] args){
    ColorScheme colorScheme = new BocaColorScheme();
    GameOfLifeVariant variant = new InmigrationVariant(); char[][] input = {
      {'w','b','w','w','w'},
      {'w','w','y','w','w'},
      {'b','b','y','w','w'},
      {'w','w','w','w','w'},
      {'w','w','w','w','w'}
    };

    GameOfLife game = new GameOfLife(input,colorScheme,variant);

    Observer black = new BlackAliveDisplay(game);
    Observer white = new WhiteAliveDisplay(game);
    game.registerObserver(black);
    game.nextGeneration();
    game.registerObserver(white);
    game.nextGeneration();
  }

}
