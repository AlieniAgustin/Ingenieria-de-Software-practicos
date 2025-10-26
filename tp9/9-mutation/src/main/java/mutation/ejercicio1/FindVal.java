package mutation.ejercicio1;

public class FindVal{
  /**
  * Find last index of element
  *
  * @param numbers array to search
  * @param val value to look for
  * @return last index of val in numbers; -1 if absent
  * @throws NullPointerException if numbers is null
  */
  public static int findVal(int numbers[], int val){
    int findVal = -1;

    //for(int i = 0; i < numbers.length; i++)
    //mutante:
    for(int i = (0 + 1); i < numbers.length; i++)
      if(numbers[i] == val)
        findVal = i;

    return findVal;
  }
}

