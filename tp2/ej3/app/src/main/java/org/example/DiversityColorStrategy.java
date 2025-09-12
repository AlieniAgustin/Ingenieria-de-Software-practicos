package org.example;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DiversityColorStrategy implements ColorStrategy{

  /**
   * en DiversityColorStrategy cuando una celula nace, mira los estados de 
   * las n vecinas que causaron su nacimiento:
   * si todas son distintas => la nueva celula toma el primer color que todavia 
   * no uso nadie 
   * si hay vecinas con el mismo estado => la nueva celula toma el color predominante
   * entre sus vecinas
   */ 
  public DiversityColorStrategy(){ }

  /**
   * @pre !colorsOfLivingNeighbors.isEmpty() && colorsOfLivingNeighbors tiene 
   * todos los colores del ColorScheme, con 
   * las cantidades de vecinos de la celula actual que poseen dichos colores, 
   * incluso se cuentan aquellos colores que no tiene ninguna de las vecinas 
   * @post retorna el color que debe tomar la celula que revive 
   */
  public Color getNewColorForRevive(Map<Color,Integer> colorsOfLivingNeighbors){
    //obtengo una lista de los values del map con repetidos
    List<Integer> numbersOfNeighbors = new ArrayList<>(colorsOfLivingNeighbors.values());

    //ordeno esa lista en forma descendente
    Collections.sort(numbersOfNeighbors, Collections.reverseOrder());

    boolean areAllDifferent = different(numbersOfNeighbors);
    Set<Color> colors = colorsOfLivingNeighbors.keySet();

    Color colorForRevive = null;

    if(areAllDifferent){
      for(Color color : colors){
        //en caso de que el color actual no lo tenga ninguna celula vecina 
        // => es el color para la nueva celula
        if(colorsOfLivingNeighbors.get(color) == 0){
          colorForRevive = color;
          break;
        }
      }
    }else{
      //como numbersOfNeighbors esta ordenada de forma decreciente, entonces en su primera posicion 
      //esta la mayor cantidad de veces que aparece un color 
      int predominantColorNumber = numbersOfNeighbors.get(0);
      for(Color color : colors){
        //en caso de que el color actual aparezca la misma cantidad de veces que indica 
        //predominantColorNumber => ese es el color para mi celula
        if(colorsOfLivingNeighbors.get(color) == predominantColorNumber){
          colorForRevive = color;
          break; 
        }
      }
    }
    
    return colorForRevive;
  }

  /**
   * @post retorna true si no existen dos o mas celulas con el mismo color 
   */
  private boolean different(List<Integer> numbersOfNeighbors){
    for(int i = 0; i < numbersOfNeighbors.size(); i++){
      if(numbersOfNeighbors.get(i) >= 2) 
        return false;
      if(numbersOfNeighbors.get(i) == 0) 
        return true; //ya q esta ordenada decrecientemente
    }
    //si llegue al final, entonces son todos distintos
    return true;
  }

}
