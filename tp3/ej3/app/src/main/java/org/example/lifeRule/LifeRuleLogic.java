package org.example.lifeRule;

import org.example.cell.Cell;
import org.example.colorStrategy.ColorStrategy;
import org.example.color.Color;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
        finalCells[i][j] = new Cell(cells[i][j].isAlive(), cells[i][j].getColorScheme(), cells[i][j].getColor());
  }

  public Cell[][] nextGeneration(Cell[][] cells, ColorStrategy colorStrategy){
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
        
        //si la celula nace => uso el ColorStrategy para designar su nuevo color 
        if(!currentCell.isAlive() && willBeAlive){
          Map<Color,Integer> colorsOfLivingNeighbors = getColorsOfLivingNeighbors(i,j,cells);
          finalCells[i][j].setColor(colorStrategy.getNewColorForRevive(colorsOfLivingNeighbors));
        }else if(currentCell.isAlive() && !willBeAlive){
          //si la celula muere => toma el color de muerta designado por su colorScheme
          finalCells[i][j].setColor(cells[i][j].getColorScheme().getDeadCellColor());
        }
      }
    }
    return finalCells;
  }

  /**
   * @pre 0 <= row < cells.length && 0 <= column < cells[0].length
   * @post retorna la cantidad de celulas vecinas vivas de cells[row][column]
   */
  private int getAliveNeighborsCount(int row, int column, Cell[][] cells) {
    int count = 0;
    int numberOfRows = cells.length;
    int numberOfColumns = cells[0].length;

    //recorro las posiciones vecinas relativas
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
  
  /**
   * @post retorna un map con cada color de celulas vivas del ColorScheme, junto con la cantidad 
   * de celulas vecinas que poseen dicho color 
   */
  private Map<Color,Integer> getColorsOfLivingNeighbors(int row, int column, Cell[][] cells){
    Map<Color,Integer> colorsOfLivingNeighbors = new HashMap<>();
    
    //obtengo los colores de las celulas vivas 
    List<Color> liveCellColors = cells[row][column].getColorScheme().getLiveCellColors();
    
    for(Color color : liveCellColors)
      //inicializo cada color con 0
      colorsOfLivingNeighbors.put(color, 0);

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
          
          //si el vecino esta vivo, me fijo su color y lo incremento en el map 
          if (cells[neighborRow][neighborCol].isAlive()) {
            Color cellColor = cells[neighborRow][neighborCol].getColor();
            int oldValue = colorsOfLivingNeighbors.get(cellColor);
            colorsOfLivingNeighbors.put(cellColor,oldValue+1);
          }
        }
      }
    }
   
    return colorsOfLivingNeighbors;
  }

}
