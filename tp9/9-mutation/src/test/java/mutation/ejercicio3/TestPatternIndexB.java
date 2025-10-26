package mutation.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPatternIndexB{

  @Test 
  public void patternDoesNotAppearsInSubject1(){
    //se alcanza al mutante y no se tiene infeccion, ya que el estado interno del programa no difiere del 
    //estado sin el mutante. Esto ocurre porque u == u, pero s != l, por ende se deja de buscar subsecuencias (consecuencia del mutante),
    //pero igualmente no me interesaba seguir buscandolas, ya que no hay mas subsecuencias
    String subject = "agus";
    String pattern = "ul";
    int expectedPatternIndex = -1;
    int currentPatternIndex = PatternIndexB.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternDoesNotAppearsInSubject2(){
    //se alcanza al mutante y se tiene infeccion, ya que el estado interno del programa difiere del estado sin el mutante.
    //Esto ocurre porque a == a, g == g, u == u, s != z, por ende se deja de buscar subsecuencias (consecuencia del mutante),
    //cuando yo deberia seguir buscandolas, pues quedan otras por verificar. No se tiene propagacion pues aunque hubiese 
    //seguido buscando subsecuencias, ninguna era pattern => el resultado es el mismo que sin buscarlas
    String subject = "agustinnnn";
    String pattern = "aguz";
    int expectedPatternIndex = -1;
    int currentPatternIndex = PatternIndexB.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsASubsequenceOfSubject1(){
    //se llega al mutante porque g == g, u != a, dejando de buscar subsecuencias posibles de subject que sean pattern.
    //Hay un error, pues yo deberia seguir buscandolas, pues pattern es subsecuencia de subject
    String subject = "agustinga";
    String pattern = "ga";
    int expectedPatternIndex = 7;
    int currentPatternIndex = PatternIndexB.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern); sin mutante
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsASubsequenceOfSubject2(){
    //se llega al mutante porque a == a, l != s, dejando de buscar subsecuencias posibles de subject que sean pattern.
    //Hay un error, pues yo deberia seguir buscandolas, pues pattern es subsecuencia de subject
    String subject = "alasas";
    String pattern = "as";
    int expectedPatternIndex = 2;
    int currentPatternIndex = PatternIndexB.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern); sin mutante
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

}

