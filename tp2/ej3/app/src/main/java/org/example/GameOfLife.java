package org.example;

public class GameOfLife{

  private Cell[][] cells;
  private int generationNumber;
  private int numberOfRows;
  private int numberOfColumns;
  private LifeRule rule;

  public GameOfLife(char[][] input, LifeRule rule){
    this.generationNumber = 1;
    this.rule = rule;
    numberOfRows = input.length;
    numberOfColumns = input[0].length;
    cells = new Cell[numberOfRows][numberOfColumns];

    for(int i = 0; i < numberOfRows; i++)
      for(int j = 0; j < numberOfColumns; j++)
        this.cells[i][j] = new Cell(input[i][j] == '*');
  }

  public void nextGeneration(){
    this.cells = rule.nextGeneration(this.cells);
    this.generationNumber++;
  }
 
  public String toString(){
    String answer = "Generation " + this.generationNumber + ": \n";
    answer += this.numberOfRows + " " + this.numberOfColumns + "\n";
    
    for(int i = 0; i < this.numberOfRows; i++){
      for(int j = 0; j < this.numberOfColumns; j++){
        answer += this.cells[i][j].toString();
      }
      answer += "\n";
    }
    
    return answer;
  }

}
