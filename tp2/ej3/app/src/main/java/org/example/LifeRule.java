package org.example;

public interface LifeRule{
  
  public Cell[][] nextGeneration(Cell[][] cells);
  public boolean isApplicableB(Cell currentCell, int aliveNeighborsCount);
  public boolean isApplicableS(Cell currentCell, int aliveNeighborsCount);
}
