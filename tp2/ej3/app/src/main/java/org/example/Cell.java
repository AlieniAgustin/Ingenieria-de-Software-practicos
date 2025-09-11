package org.example;

public class Cell{
  private boolean alive;
  private ColorScheme colorScheme;

  public Cell(boolean alive, ColorScheme colorScheme){
    this.alive = alive;
    this.colorScheme = colorScheme;
  }

  public boolean isAlive(){
    return alive;
  }

  public void setAlive(boolean alive){
    this.alive = alive;
  }

  public Color getColor(){
    return (this.alive) ? colorScheme.getLiveCellColor() : colorScheme.getDeadCellColor();
  }

  public String toString(){
    //el toString de una celula sera la primer letra del color que les correponde en mayuscula
    String answer = alive ? colorScheme.getLiveCellColor().toString() : colorScheme.getDeadCellColor().toString();
    return answer;
  }

  public ColorScheme getColorScheme(){
    return this.colorScheme;
  }

}
