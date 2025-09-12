package org.example;

public class Cell{
  private boolean alive;
  private ColorScheme colorScheme;
  private Color color;

  public Cell(boolean alive, ColorScheme colorScheme, Color color){
    this.alive = alive;
    this.colorScheme = colorScheme;
    this.color = color;
  }

  public boolean isAlive(){
    return alive;
  }

  public void setAlive(boolean alive){
    this.alive = alive;
  }

  public Color getColor(){
    return color;
  }

  public void setColor(Color color){
    this.color = color;
  }

  public String toString(){
    return color.toString();
  }

  public ColorScheme getColorScheme(){
    return this.colorScheme;
  }

}
