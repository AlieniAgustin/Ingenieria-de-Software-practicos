package org.example.gameOfLifeVariant;

import org.example.lifeRule.LifeRule;
import org.example.colorStrategy.ColorStrategy; 
import org.example.lifeRule.StandardLife;
import org.example.colorStrategy.DiversityColorStrategy;
import org.example.cell.Cell;

public class QuadLifeVariant implements GameOfLifeVariant{

  private LifeRule lifeRule;
  private ColorStrategy colorStrategy;

  public QuadLifeVariant(){ 
    lifeRule = new StandardLife();
    colorStrategy = new DiversityColorStrategy();
  }

  public Cell[][] nextGeneration(Cell[][] cells){
    return lifeRule.nextGeneration(cells,colorStrategy);
  }

  public int getCellsDied(){
    return lifeRule.getCellsDied();
  }

  public int getCellsSurvived(){
    return lifeRule.getCellsSurvived();
  }

  public int getCellsBorn(){
    return lifeRule.getCellsBorn();
  }
}
