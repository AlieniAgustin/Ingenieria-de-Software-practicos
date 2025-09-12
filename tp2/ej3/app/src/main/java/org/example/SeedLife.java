package org.example;

import java.util.ArrayList;

public class SeedLife extends LifeRuleLogic{

  /**
   * en las reglas SeedLife, una celula muerta nace si tiene exactamente 2 vecinos vivos,
   * y siempre una celula viva muere
   */

  public SeedLife(){
    b = new ArrayList<>();
    s = new ArrayList<>();
    b.add(2);
  }

}
