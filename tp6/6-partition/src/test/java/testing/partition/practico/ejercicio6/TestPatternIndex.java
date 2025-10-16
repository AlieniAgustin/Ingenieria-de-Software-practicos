package testing.partition.practico.ejercicio6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPatternIndex{

  @Test 
  public void subjectAndPatternAreNull(){
    String subject = null;
    String pattern = null;
    assertThrows(NullPointerException.class, () -> PatternIndex.patternIndex(subject,pattern));
  }

  @Test 
  public void subjectIsNullAndPatternIsNotEmpty(){
    String subject = null;
    String pattern = "a";
    assertThrows(NullPointerException.class, () -> PatternIndex.patternIndex(subject,pattern));
  }

  @Test 
  public void subjectIsNullAndPatternIsEmpty(){
    String subject = null;
    String pattern = "";
    assertThrows(NullPointerException.class, () -> PatternIndex.patternIndex(subject,pattern));
  }

  @Test 
  public void PatternIsNullAndSubjectIsNotEmpty(){
    String subject = "a";
    String pattern = null;
    assertThrows(NullPointerException.class, () -> PatternIndex.patternIndex(subject,pattern));
  }

  @Test 
  public void PatternIsNullAndSubjectIsEmpty(){
    String subject = "";
    String pattern = null;
    assertThrows(NullPointerException.class, () -> PatternIndex.patternIndex(subject,pattern));
  }

  @Test 
  public void SubjectAndPatternAreEmpty(){
    String subject = "";
    String pattern = "";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(0,answer);
  }

  @Test 
  public void SubjectIsNotEmptyAndPatternIsEmpty(){
    String subject = "a";
    String pattern = "";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(0,answer);
  }

  @Test 
  public void SubjectIsEmptyAndPatternIsNotEmpty(){
    String subject = "";
    String pattern = "a";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(-1,answer);
  }

  @Test 
  public void patternDoesNotAppearInSubject(){
    String subject = "abc";
    String pattern = "bcc";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(-1,answer);
  }

  @Test 
  public void patternAppearsOnlyOnceInSubject(){
    String subject = "abcadf";
    String pattern = "cad";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(2,answer);
  }

  @Test 
  public void patternAppearsSeveralTimesInSubject(){
    String subject = "agustinelmasproproplayer";
    String pattern = "pro";
    int answer = PatternIndex.patternIndex(subject,pattern);
    assertEquals(12,answer);
  }

}


