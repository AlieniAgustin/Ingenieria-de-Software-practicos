package org.example;

import java.util.List;

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

public interface ColorScheme{

  public List<Color> getLiveCellColors();

  public Color getDeadCellColor();
}
