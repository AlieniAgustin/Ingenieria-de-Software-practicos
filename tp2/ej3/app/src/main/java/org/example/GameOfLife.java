package org.example;

public class GameOfLife{

  private Cell[][] cells;
  private int generationNumber;
  private int numberOfRows;
  private int numberOfColumns;

  public GameOfLife(char[][] input){
    this.generationNumber = 1;
    numberOfRows = input.length;
    numberOfColumns = input[0].length;
    cells = new Cell[numberOfRows][numberOfColumns];

    for(int i = 0; i < numberOfRows; i++)
      for(int j = 0; j < numberOfColumns; j++)
        this.cells[i][j] = new Cell(input[i][j] == '*');
  }

  public void nextGeneration(){
    
    for(int i = 0; i < this.numberOfRows; i++){
      for(int j = 0; j < this.numberOfColumns; j++){
        Cell currentCell = this.cells[i][j];
        int aliveNeighborsCount = getAliveNeighborsCount(i,j);

        if(currentCell.isAlive() && (aliveNeighborsCount < 2 || aliveNeighborsCount > 3))
          currentCell.setAlive(false);
        else if(!currentCell.isAlive() && aliveNeighborsCount == 3)
          currentCell.setAlive(true);
      }
    }

    this.generationNumber++;
  }

  public int getGenerationNumber(){
    return this.generationNumber;
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

  private int getAliveNeighborsCount(int row, int column){
    int count = 0;
    if(row == 0 && column == 0){

    }else if(row == 0 && column == this.numberOfColumns - 1){

    }else if(row == this.numberOfRows - 1 && column == 0){

    }else if(row == this.numberOfRows - 1 && column == this.numberOfColumns - 1){

    }else if(row == 0){

    }else if(row == this.numberOfRows - 1){

    }else if(column == 0){

    }else if(column == this.numberOfColumns - 1){

    }else{
      
    }
  }

}
