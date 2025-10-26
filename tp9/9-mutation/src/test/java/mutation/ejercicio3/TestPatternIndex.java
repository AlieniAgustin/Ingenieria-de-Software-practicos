package mutation.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestPatternIndex{

  @Test 
  public void patternAppearsOnceInTheSubject(){
    String subject = "agustin";
    String pattern = "gu";
    int expectedPatternIndex = 1;
    int currentPatternIndex = PatternIndex.patternIndex(subject,pattern);
    assertEquals(expectedPatternIndex,currentPatternIndex);
  }
}

