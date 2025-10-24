package ejercicio3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTriTyp{

  @Test 
  public void testItIsNotATriangleBecauseItHasANegativeSide(){
    //hay un lado negativo
    int expectedAnswer = 4;
    int side1 = -1;
    int side2 = 2;
    int side3 = 3;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsNotATriangleBecauseTheTriangularInequalityIsNotFulfilled(){
    //los 3 lados son positivos, son todos distintos, pero no se cumple la desigualdad triangular, 
    //o sea, hay dos lados donde su suma es <= que el restante
    int expectedAnswer = 4;
    int side1 = 1;
    int side2 = 2;
    int side3 = 5;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsAScaleneTriangle(){
    //los 3 lados son positivos, son todos distintos, se cumple la desigualdad triangular,
    //entonces es un triangulo escaleno
    int expectedAnswer = 1;
    int side1 = 2;
    int side2 = 4;
    int side3 = 3;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsAnIsoscelesTriangleWithTheFirstTwoSidesEqual(){
    //los 3 lados son positivos, solo los primeros dos son iguales, y respetan
    //la desigualdad trangular entonces es un triangulo isosceles
    int expectedAnswer = 2;
    int side1 = 2;
    int side2 = 2;
    int side3 = 3;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsAnIsoscelesTriangleWithTheFirstAndThirdSidesEqual(){
    //los 3 lados son positivos, solo el primer y tercer lado son iguales, 
    //y respetan la desigualdad trangular entonces es un triangulo isosceles
    int expectedAnswer = 2;
    int side1 = 2;
    int side2 = 3;
    int side3 = 2;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsAnIsoscelesTriangleWithTheSecondAndThirdSidesEqual(){
    //los 3 lados son positivos, solo el segundo y tercer lado son iguales, 
    //y respetan la desigualdad trangular entonces es un triangulo isosceles
    int expectedAnswer = 2;
    int side1 = 3;
    int side2 = 2;
    int side3 = 2;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsAnEquilateralTriangle(){
    //los 3 lados son positivos, los tres lados son iguales, 
    //y respetan la desigualdad trangular entonces es un triangulo equilatero
    int expectedAnswer = 3;
    int side1 = 3;
    int side2 = 3;
    int side3 = 3;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

  @Test 
  public void testItIsNotATriangleBecauseItDoesNotSatisfyTheTriangularInequality(){
    //los 3 lados son positivos, los primeros dos lados son iguales,
    //pero el tercero es mayor que la suma de los dos primeros, entonces no es un triangulo 
    //porque rompe con la desigualdad triangular
    int expectedAnswer = 4;
    int side1 = 3;
    int side2 = 3;
    int side3 = 10;
    int currentAnswer = TriTyp.triang(side1,side2,side3);
    assertEquals(expectedAnswer,currentAnswer);
  }

}
