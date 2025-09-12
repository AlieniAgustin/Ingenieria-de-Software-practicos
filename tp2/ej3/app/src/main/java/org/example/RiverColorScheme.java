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
public class RiverColorScheme implements ColorScheme{

  private List<Color> liveCellColors;
  private Color deadCellColor;

  public RiverColorScheme(){ 
    liveCellColors = new ArrayList<>();
    liveCellColors.add(new Color("red"));
    liveCellColors.add(new Color("white"));
    deadCellColor = new Color("black");
  }

  public List<Color> getLiveCellColors(){
    return liveCellColors;
  }

  public Color getDeadCellColor(){
    return deadCellColor;
  }

}
