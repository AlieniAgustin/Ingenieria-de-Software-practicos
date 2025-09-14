package org.example.gameOfLifeVariant;

import org.example.cell.Cell;

public interface GameOfLifeVariant{

  public Cell[][] nextGeneration(Cell[][] cells);

}
