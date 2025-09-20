package org.example.gameOfLifeVariant;

import org.example.cell.Cell;

public interface GameOfLifeVariant{

  public Cell[][] nextGeneration(Cell[][] cells);
  public int getCellsDied();
  public int getCellsSurvived();
  public int getCellsBorn();

}
