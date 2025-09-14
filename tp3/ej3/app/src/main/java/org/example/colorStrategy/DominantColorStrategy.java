package org.example.colorStrategy;

import org.example.color.Color;
import java.util.Map;
import java.util.Set;

public class DominantColorStrategy implements ColorStrategy{

  /**
   * en DominantColorStrategy el color que toma una celula que revive, 
   * es el color que tiene la mayoria de sus vecinas vivas
   */
  public DominantColorStrategy(){ }

   /**
   * @pre !colorsOfLivingNeighbors.isEmpty() && colorsOfLivingNeighbors tiene 
   * todos los colores del ColorScheme, con 
   * las cantidades de vecinos de la celula actual que poseen dichos colores, 
   * incluso se cuentan aquellos colores que no tiene ninguna de las vecinas 
   * @post retorna el color que debe tomar la celula que revive 
   */
  public Color getNewColorForRevive(Map<Color,Integer> colorsOfLivingNeighbors){
    Set<Color> colors = colorsOfLivingNeighbors.keySet();
    Color colorWithMoreNeighbors = null;
    int maxNumberOfNeighbors = -1;

    for(Color color : colors){
      int numberOfNeighbors = colorsOfLivingNeighbors.get(color);
      
      if(numberOfNeighbors >= maxNumberOfNeighbors){
        maxNumberOfNeighbors = numberOfNeighbors;
        colorWithMoreNeighbors = color;
      }
    }

    return colorWithMoreNeighbors;
  }

}
