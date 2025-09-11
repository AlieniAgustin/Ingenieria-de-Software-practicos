package org.example;

public class RiverColorScheme implements ColorScheme{

  public RiverColorScheme(){ }

  public Color getLiveCellColor(){
    return new Color("white");
  }

  public Color getDeadCellColor(){
    return new Color("red");
  }

}
