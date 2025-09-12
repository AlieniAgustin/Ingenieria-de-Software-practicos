package org.example;

import java.util.List;
import java.util.ArrayList;

/**
 * Define el esquema de colores que usa el Game of Life.
 *
 * IMPORTANTE: Se asume que cada color vivo
 * devuelto por getLiveCellColors() comienza con una letra distinta.
 * Esa letra inicial se usa para mapear caracteres de entrada a colores
 * en GameOfLife.getColorFromChar(char).
 *
 * Si no se cumple esta condición, será necesario implementar
 * otra estrategia de mapeo (por ejemplo, comparar por nombre completo).
 */
public class BocaColorScheme implements ColorScheme{

  private List<Color> liveCellColors;
  private Color deadCellColor;

  public BocaColorScheme(){ 
    liveCellColors = new ArrayList<>();
    liveCellColors.add(new Color("yellow"));
    liveCellColors.add(new Color("blue"));
    deadCellColor = new Color("white");
  }

  public List<Color> getLiveCellColors(){
    return liveCellColors;
  }

  public Color getDeadCellColor(){
    return deadCellColor;
  }

}
