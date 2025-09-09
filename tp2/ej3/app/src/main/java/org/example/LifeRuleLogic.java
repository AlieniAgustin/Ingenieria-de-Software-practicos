package org.example;

import java.util.List;
import java.util.ArrayList;

public abstract class LifeRuleLogic implements LifeRule{

  protected List<Integer> b;
  protected List<Integer> s;
  private Cell[][] finalCells;
 
  private void cloneMatrix(Cell[][] cells){
    int numberOfRows = cells.length;
    int numberOfColumns = cells[0].length;
    finalCells = new Cell[numberOfRows][numberOfColumns];

    for(int i = 0; i < numberOfRows; i++)
      for(int j = 0; j < numberOfColumns; j++)
        finalCells[i][j] = new Cell(cells[i][j].isAlive());
  }

  public Cell[][] nextGeneration(Cell[][] cells){
    cloneMatrix(cells);
    int numberOfRows = cells.length;
    int numberOfColumns = cells[0].length;

    for(int i = 0; i < numberOfRows; i++){
      for(int j = 0; j < numberOfColumns; j++){
        Cell currentCell = cells[i][j];
        int aliveNeighborsCount = getAliveNeighborsCount(i,j,cells);

        //en la proxima generacion la celula de la fila i, columna j 
        //estara viva si se puede aplicar S o se puede aplicar B. Muerta en otro caso
        boolean willBeAlive = isApplicableS(currentCell,aliveNeighborsCount) 
                              || isApplicableB(currentCell,aliveNeighborsCount);

        finalCells[i][j].setAlive(willBeAlive);

      }
    }
    return finalCells;
  }

  private int getAliveNeighborsCount(int row, int column, Cell[][] cells) {
    int count = 0;
    int numberOfRows = cells.length;
    int numberOfColumns = cells[0].length;

    //recorremos las posiciones vecinas relativas
    //el i se usa para las filas (-1 la de arriba, 0 actual, 1 la de abajo)
    //el j se usa para las columnas (-1 la de izquierda, 0 actual, 1 la de derecha)
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        //saltar la celda actual, se vuelve a la condicion del for 
        if (i == 0 && j == 0) continue;
        
        //para calcular la posicion del vecino
        int neighborRow = row + i;
        int neighborCol = column + j;

        //verificar que el vecino está dentro de los límites
        if (neighborRow >= 0 && neighborRow < numberOfRows &&
          neighborCol >= 0 && neighborCol < numberOfColumns) {
          
          //si el vecino esta vivo, incremento count
          if (cells[neighborRow][neighborCol].isAlive()) {
            count++;
          }
        }
      }
    }

    return count;
  }

  /**
   * @pre aliveNeighborsCount >= 0
   * @post indica si una celula muerta puede nacer 
   */
  public boolean isApplicableB(Cell currentCell, int aliveNeighborsCount){
    return !currentCell.isAlive() && b.contains(aliveNeighborsCount);
  }

  /**
   * @pre aliveNeighborsCount >= 0
   * @post indica si una celula viva puede sobrevivir 
   */
  public boolean isApplicableS(Cell currentCell, int aliveNeighborsCount){
    return (currentCell.isAlive() && s.contains(aliveNeighborsCount));
  }

}
