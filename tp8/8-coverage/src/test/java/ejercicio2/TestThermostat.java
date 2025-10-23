package ejercicio2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestThermostat{

  //INSTRUCTION TESTS
  @Test 
  public void testTurnHeaterOn_WhenTempIsLowAndLagTimeSufficient_ReturnsTrue(){
    ProgrammedSettings ps = new ProgrammedSettings();
    Thermostat t = new Thermostat();
    t.setCurrentTemp(20);
    t.setThresholdDiff(2);
    t.setOverride(true);
    t.setPeriod(Period.DAY);
    t.setDay(DayType.WEEKDAY);
    t.setTimeSinceLastRun(3);
    t.setMinLag(2);
    t.setOverTemp(3);
 
    assertTrue(t.turnHeaterOn(ps)); //entra por el if interno y externo
  }

  @Test 
  public void testTurnHeaterOn_WhenLagTimeIsInsufficient_ReturnsFalse(){
    ProgrammedSettings ps = new ProgrammedSettings();
    Thermostat t = new Thermostat();
    t.setCurrentTemp(20);
    t.setThresholdDiff(2);
    t.setOverride(true);
    t.setPeriod(Period.DAY);
    t.setDay(DayType.WEEKDAY);
    t.setTimeSinceLastRun(3);
    t.setMinLag(3);
    t.setOverTemp(3);
 
    assertFalse(t.turnHeaterOn(ps)); //es false el segundo conyunto del if externo
  }

  //TEST TO BE ADDED TO ENSURE BRANCH COVERAGE
  @Test 
  public void testTurnHeaterOn_WhenProgrammedTempIsLowAndOverrideIsOff_ReturnsTrue(){
    ProgrammedSettings ps = new ProgrammedSettings();
    Thermostat t = new Thermostat();
    t.setCurrentTemp(20);
    t.setThresholdDiff(2);
    t.setOverride(false);
    t.setPeriod(Period.DAY);
    t.setDay(DayType.WEEKDAY);
    t.setTimeSinceLastRun(3);
    t.setMinLag(2);
    t.setOverTemp(3);
 
    assertTrue(t.turnHeaterOn(ps)); //entra por el if interno, no por el externo
  }

}
