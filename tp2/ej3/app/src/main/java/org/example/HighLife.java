package org.example;

import java.util.List;
import java.util.ArrayList;

public class HighLife extends LifeRuleLogic{
  
  public HighLife(){
    b = new ArrayList<>(); //una celula muerta nace cuando tiene n vecinos, con n que esta en b 
    s = new ArrayList<>(); //una celula viva sobrevive cuando tiene n vecinos, muere en caso contrario. con n que esta en s
    b.add(3);
    b.add(6);
    s.add(2);
    s.add(3);
  }
  
}
