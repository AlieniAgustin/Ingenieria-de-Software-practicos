package org.example.display;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import org.example.gameOfLife.GameOfLife;
import org.example.cell.Cell;

public class StatsDisplay implements Observer,DisplayElement{

  private GameOfLife game;
  private Cell[][] cells;
  private int numberOfCells;
  private int numberOfLivingCells;
  private int numberOfDeadCells;
  private int numberOfCellsDisplayed;
  private int totalNumberOfLiveCells;
  private int totalNumberOfDeadCells;
  private int displayCount;
  private float averageNumberOfLiveCells;
  private float averageNumberOfDeadCells;

  public StatsDisplay(GameOfLife game){
    this.game = game;
    this.game.registerObserver(this);
    this.cells = this.game.getCells();
    numberOfCells = this.cells.length * this.cells[0].length;
    numberOfCellsDisplayed = 0;
    totalNumberOfLiveCells = 0;
    totalNumberOfDeadCells = 0;
    averageNumberOfDeadCells = 0;
    averageNumberOfLiveCells = 0;
    displayCount = 0;
  }

  public void update(){
    this.cells = game.getCells();
    display();
  }

  public void display(){
    numberOfCellsDisplayed += numberOfCells;
    numberOfLivingCells = getNumberOfLivingCells();
    numberOfDeadCells = numberOfCells - numberOfLivingCells;
    totalNumberOfLiveCells += numberOfLivingCells;
    totalNumberOfDeadCells += numberOfDeadCells;
    displayCount++;
    averageNumberOfDeadCells = totalNumberOfDeadCells / (float) displayCount;
    averageNumberOfLiveCells = totalNumberOfLiveCells / (float) displayCount;
    DecimalFormat df = new DecimalFormat("##.##");
    df.setRoundingMode(RoundingMode.DOWN);
    
    String output = "Display " + displayCount + ": \n";
    output += "Number of cells: " + numberOfCells + "\nNumber of living cells: " + numberOfLivingCells + "\nNumber of dead cells: " + numberOfDeadCells + "\n";
    output += "Average number of live cells: " + df.format(averageNumberOfLiveCells) + "\nAverage number of dead cells: " + df.format(averageNumberOfDeadCells) + "\n";
    System.out.print(output);
  }

  private int getNumberOfLivingCells(){ 
    int count = 0;

    for(int i = 0; i < cells.length; i++)
      for(int j = 0; j < cells[0].length; j++)
        if(cells[i][j].isAlive()) 
          count++;

    return count;
  }

}
