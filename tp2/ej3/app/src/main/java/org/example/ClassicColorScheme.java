package org.example;

public class ClassicColorScheme implements ColorScheme{

  public ClassicColorScheme(){ }

  public Color getLiveCellColor(){
    return new Color("white");
  }

  public Color getDeadCellColor(){
    return new Color("black");
  }

}
