package org.example;

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

}
