package org.example.lifeRule;

import org.example.cell.Cell;
import org.example.colorStrategy.ColorStrategy;

public interface LifeRule{
  
  public Cell[][] nextGeneration(Cell[][] cells, ColorStrategy colorStrategy);
  public boolean isApplicableB(Cell currentCell, int aliveNeighborsCount);
  public boolean isApplicableS(Cell currentCell, int aliveNeighborsCount);
}
