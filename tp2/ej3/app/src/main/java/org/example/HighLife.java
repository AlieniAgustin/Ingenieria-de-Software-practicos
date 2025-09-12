package org.example;

import java.util.ArrayList;

public class HighLife extends LifeRuleLogic{

  /**
   * en las reglas HighLife, una celula muerta nace si tiene exactamente 3 o 6 vecinos vivos,
   * y una celula viva sobrevive si tiene exactamente 2 o 3 vecinos vivos 
   */

  public HighLife(){
    b = new ArrayList<>(); //una celula muerta nace cuando tiene n vecinos, con n que esta en b 
    s = new ArrayList<>(); //una celula viva sobrevive cuando tiene n vecinos, muere en caso contrario. con n que esta en s
    b.add(3);
    b.add(6);
    s.add(2);
    s.add(3);
  }
  
}
