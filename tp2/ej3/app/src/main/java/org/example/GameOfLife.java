package org.example;

import java.util.List;

public class GameOfLife{

  private Cell[][] cells;
  private int generationNumber;
  private int numberOfRows;
  private int numberOfColumns;
  private GameOfLifeVariant variant;
  private ColorScheme colorScheme;


  /**
  * IMPORTANTE:
  * Se asume que todos los colores del ColorScheme
  * comienzan con letras distintas.
  * Si no fuera así, habría que usar el nombre completo del color
  * o una lógica distinta para mapear el `char` al `Color`.
  */
  public GameOfLife(char[][] input, ColorScheme colorScheme, GameOfLifeVariant variant){
    this.generationNumber = 1;
    this.colorScheme = colorScheme;
    this.variant = variant;
    numberOfRows = input.length;
    numberOfColumns = input[0].length;
    cells = new Cell[numberOfRows][numberOfColumns];

    for(int i = 0; i < numberOfRows; i++){
      for(int j = 0; j < numberOfColumns; j++){
        Color color = getColorFromChar(input[i][j]);
        this.cells[i][j] = new Cell(colorScheme.getLiveCellColors().contains(color), colorScheme, color);
      }
    }
  }

  private Color getColorFromChar(char c){
    Color deadCellColor = colorScheme.getDeadCellColor();
    //transformo el char a mayuscula, ya que el toString de un color retorna la primer letra del color en mayuscula (en string)
    char cUpper = Character.toUpperCase(c);
    if(deadCellColor.toString().charAt(0) == cUpper){
      return deadCellColor;
    }else{
      List<Color> liveCellColors = colorScheme.getLiveCellColors();
      for(Color color : liveCellColors)
        if(color.toString().charAt(0) == cUpper)
          return color;
      //si o si el char deberia ser la primer letra de uno de los colores
      throw new IllegalArgumentException();
    }
  }

  public void nextGeneration(){
    cells = variant.nextGeneration(cells);
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
