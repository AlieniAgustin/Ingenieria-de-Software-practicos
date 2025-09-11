package org.example;

public class BocaColorScheme implements ColorScheme{

  public BocaColorScheme(){ }

  public Color getLiveCellColor(){
    return new Color("yellow");
  }

  public Color getDeadCellColor(){
    return new Color("blue");
  }

}
