package mutation.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPatternIndexA{

  @Test 
  public void patternDoesNotAppearsInSubject(){
    //ademas, alcanza al mutante, ya que patternLen < subjectLen
    String subject = "agustin";
    String pattern = "hul";
    int expectedPatternIndex = -1;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsASubsequenceOfSubjectButNotAFinalSubsequence1(){
    //se alcanza al mutante, pero no se produce infeccion ya que el estado interno del programa no cambia,
    //y eso se obtiene cuando no me hace falta verificar que pattern pueda ser subsecuencia final de subject.
    //para no necesitar verificar eso, pattern debe ser subsecuencia de subject, pero no final
    String subject = "agustin";
    String pattern = "gu";
    int expectedPatternIndex = 1;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsASubsequenceOfSubjectButNotAFinalSubsequence2(){
    //se alcanza al mutante, pero no se produce infeccion ya que el estado interno del programa no cambia,
    //y eso se obtiene cuando no me hace falta verificar que pattern pueda ser subsecuencia final de subject.
    //para no necesitar verificar eso, pattern debe ser subsecuencia de subject, pero no final
    String subject = "agustin";
    String pattern = "ti";
    int expectedPatternIndex = 4;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsNotASubsequenceOfSubject1(){
    String subject = "agustin";
    String pattern = "ho";
    int expectedPatternIndex = -1;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsNotASubsequenceOfSubject2(){
    String subject = "agus";
    String pattern = "aguz";
    int expectedPatternIndex = -1;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsFinalSubsequenceOfSubject1(){
    String subject = "agus";
    String pattern = "s";
    int expectedPatternIndex = 3;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern); sin el mutante, el test pasa 
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

  @Test 
  public void patternIsFinalSubsequenceOfSubject2(){
    String subject = "agus";
    String pattern = "gus";
    int expectedPatternIndex = 1;
    int currentPatternIndex = PatternIndexA.patternIndex(subject,pattern);
    //int currentPatternIndex = PatternIndex.patternIndex(subject,pattern); sin el mutante el test pasa
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }

}

