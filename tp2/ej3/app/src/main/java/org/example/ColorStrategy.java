package org.example;

import java.util.Map;

public interface ColorStrategy{
  /**
   * @pre !colorsOfLivingNeighbors.isEmpty() && colorsOfLivingNeighbors tiene 
   * todos los colores del ColorScheme, con 
   * las cantidades de vecinos de la celula actual que poseen dichos colores, 
   * incluso se cuentan aquellos colores que no tiene ninguna de las vecinas 
   * @post retorna el color que debe tomar la celula que revive 
   */
  public Color getNewColorForRevive(Map<Color,Integer> colorsOfLivingNeighbors);

}
