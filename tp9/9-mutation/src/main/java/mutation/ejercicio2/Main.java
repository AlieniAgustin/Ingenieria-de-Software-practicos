package mutation.ejercicio2;

public class Main{

  /**
  * Sum values in an array
  *
  * @param x array to sum
  * @return sum of values in x
  * @throws NullPointerException if x is null 
  */
  public static int sum(int[] x){
    int s = 0;
    for(int i = 0; i < x.length; i++){
      s = s + x[i];
      //mutante:
      //s = s - x[i];
    }
    return s;
  }


}
