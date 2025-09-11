package org.example;

public class Color{

  private String colorName;

  public Color(String colorName){
    this.colorName = colorName;
  }

  public String getColorName(){
    return this.colorName;
  }

  public String toString(){
    String firstCapitalLetter = "";
    if(!colorName.isEmpty())
      firstCapitalLetter += String.valueOf(Character.toUpperCase(colorName.charAt(0)));
    
    return firstCapitalLetter;
  }

}
