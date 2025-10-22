package ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCal{

  @Test 
  public void testCalSameMonth(){
    int month1 = 2;
    int month2 = 2;
    int day1 = 4;
    int day2 = 7;
    int year = 1990;
    int currentCal = Cal.cal(month1,day1,month2,day2,year);
    int expectedCal = 3;
    assertEquals(expectedCal,currentCal);
  }

  @Test 
  public void testCalConsecutiveMonthsNonLeapYear(){
    int month1 = 5;
    int month2 = 6;
    int day1 = 10;
    int day2 = 20;
    int year = 2025;
    int currentCal = Cal.cal(month1,day1,month2,day2,year);
    int expectedCal = 41;
    assertEquals(expectedCal,currentCal);
  }

  @Test 
  public void testCalWithIntermediateMonthsLeapYear(){
    int month1 = 5;
    int month2 = 7;
    int day1 = 10;
    int day2 = 20;
    int year = 2024;
    int currentCal = Cal.cal(month1,day1,month2,day2,year);
    int expectedCal = 71;
    assertEquals(expectedCal,currentCal);
  }

}
