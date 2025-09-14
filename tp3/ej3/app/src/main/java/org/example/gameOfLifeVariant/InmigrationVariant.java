package org.example.gameOfLifeVariant;

import org.example.lifeRule.LifeRule;
import org.example.colorStrategy.ColorStrategy;
import org.example.lifeRule.StandardLife;
import org.example.colorStrategy.DominantColorStrategy;
import org.example.cell.Cell;

public class InmigrationVariant implements GameOfLifeVariant{

  private LifeRule lifeRule;
  private ColorStrategy colorStrategy;

  public InmigrationVariant(){ 
    lifeRule = new StandardLife();
    colorStrategy = new DominantColorStrategy();
  }

  public Cell[][] nextGeneration(Cell[][] cells){
    return lifeRule.nextGeneration(cells,colorStrategy);
  }

}
