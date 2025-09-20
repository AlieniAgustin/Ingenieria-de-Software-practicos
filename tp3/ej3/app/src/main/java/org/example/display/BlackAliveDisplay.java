package org.example.display;

import org.example.cell.Cell;
import org.example.gameOfLife.GameOfLife;

public class BlackAliveDisplay implements Observer,DisplayElement{

  private GameOfLife game;
  private Cell[][] cells;

  public BlackAliveDisplay(GameOfLife game){
    this.game = game;
    this.game.registerObserver(this);
    this.cells = this.game.getCells();
  }

  public void update(){
    this.cells = this.game.getCells();
    display();
  }

  public void display(){
    String print = "";
    for(int i = 0; i < cells.length; i ++){
      for(int j = 0; j < cells[0].length; j++){
        Cell currentCell = cells[i][j];
        print += (currentCell.isAlive()) ? "B" : "W";
      }
      print += "\n";
    }
    System.out.println(print);
  }
}
