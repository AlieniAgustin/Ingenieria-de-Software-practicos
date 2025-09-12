package org.example;

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
