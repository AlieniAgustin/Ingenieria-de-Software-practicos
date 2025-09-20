package org.example.gameOfLife;

import org.example.cell.Cell;
import org.example.gameOfLifeVariant.GameOfLifeVariant;
import org.example.colorScheme.ColorScheme;
import org.example.color.Color;
import org.example.display.Observer;
import java.util.List;
import java.util.ArrayList;

public class GameOfLife{

  private Cell[][] cells;
  private int generationNumber;
  private int numberOfRows;
  private int numberOfColumns;
  private GameOfLifeVariant variant;
  private ColorScheme colorScheme;
  private List<Observer> observers;

  /**
  * IMPORTANTE:
  * Se asume que todos los colores del ColorScheme
  * comienzan con letras distintas.
  * Si no fuera así, habría que usar el nombre completo del color
  * o una lógica distinta para mapear el `char` al `Color`.
  */
  public GameOfLife(char[][] input, ColorScheme colorScheme, GameOfLifeVariant variant){
    this.observers = new ArrayList<>();
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
    notifyObservers();
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

  public void registerObserver(Observer o){
    observers.add(o);
  }

  public void removeObserver(Observer o){
    observers.remove(o);
  }

  public void notifyObservers(){
    for(Observer o : observers)
      o.update();
  }

  public Cell[][] getCells(){
    return cells;
  }

  public int getCellsDied(){
    return variant.getCellsDied();
  }

  public int getCellsSurvived(){
    return variant.getCellsSurvived();
  }

  public int getCellsBorn(){
    return variant.getCellsBorn();
  }
}
