package mocks.ejercicio2;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestIPBlackList{

  @Test 
  public void SuccessfulLoginOnSecondAttempt(){
    String wrongPassword = "futvol";
    String correctPassword = "futbol";
    String ip = "192.168.0.1";
    String userName = "agus";

    LoginService mockLoginService = createMock(LoginService.class);

    String wrongPasswordHash = Utils.getPasswordHashMD5(wrongPassword);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash)).andReturn(false);
    String correctPasswordHash = Utils.getPasswordHashMD5(correctPassword);
    expect(mockLoginService.login(ip,userName,correctPasswordHash)).andReturn(true);

    replay(mockLoginService);

    IPBlacklist ipBlacklist = new IPBlacklist();
    ipBlacklist.setService(mockLoginService);
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword));
    assertTrue(ipBlacklist.login(ip,userName,correctPassword));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void ipBlacklistedAfterThreeFailedAttempts(){
    String wrongPassword1 = "futvol";
    String wrongPassword2 = "futbo";
    String wrongPassword3 = "fulbo";
    String ip = "192.168.0.1";
    String userName = "agus";

    LoginService mockLoginService = createMock(LoginService.class);

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash1)).andReturn(false);

    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash2)).andReturn(false);

    String wrongPasswordHash3 = Utils.getPasswordHashMD5(wrongPassword3);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash3)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlacklist = new IPBlacklist();
    ipBlacklist.setService(mockLoginService);
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword1));
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword2));
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword3));

    assertTrue(ipBlacklist.blacklisted(ip));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void anIpThatAttemptsToLogInLessThanThreeTimesDoesNotAppearOnTheBlacklist(){
    String wrongPassword1 = "futvol";
    String wrongPassword2 = "futbo";
    String ip = "192.168.0.1";
    String userName = "agus";

    LoginService mockLoginService = createMock(LoginService.class);

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash1)).andReturn(false);

    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash2)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlacklist = new IPBlacklist();
    ipBlacklist.setService(mockLoginService);
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword1));
    assertFalse(ipBlacklist.login(ip,userName,wrongPassword2));

    assertFalse(ipBlacklist.blacklisted(ip));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void ipIsInBlackList(){
    //codigo correspondiente al test 1 
    //primero debo hacer lo necesario para que la ip este en la lista negra 
    String ip = "192.168.0.1";
    String userName = "agus";
    String wrongPassword1 = "augs";
    String wrongPassword2 = "agsu";
    String wrongPassword3 = "suga";
    String correctPassword = "agus";

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);
    String wrongPasswordHash3 = Utils.getPasswordHashMD5(wrongPassword3);

    LoginService mockLoginService = createMock(LoginService.class);

    expect(mockLoginService.login(ip,userName,wrongPasswordHash1)).andReturn(false);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash2)).andReturn(false);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash3)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlackList = new IPBlacklist();
    ipBlackList.setService(mockLoginService);
    //esto es necesario para poner la ip en la lista negra, y asi poder entrar a la rama del test 1 
    assertFalse(ipBlackList.login(ip,userName,wrongPassword1));
    assertFalse(ipBlackList.login(ip,userName,wrongPassword2));
    assertFalse(ipBlackList.login(ip,userName,wrongPassword3));

    //aunque ponga la contraseña correcta, como la ip ya se bloqueo, entrara por el primer if then
    assertFalse(ipBlackList.login(ip,userName,correctPassword)); 
    assertTrue(ipBlackList.blacklisted(ip));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void successfulLoginOnTheFirstAttempt(){
    //test 2 de ramas

    String ip = "192.168.0.1";
    String userName = "agus";
    String correctPassword = "agus";

    String correctPasswordHash = Utils.getPasswordHashMD5(correctPassword);

    LoginService mockLoginService = createMock(LoginService.class);

    expect(mockLoginService.login(ip,userName,correctPasswordHash)).andReturn(true);

    replay(mockLoginService);

    IPBlacklist ipBlackList = new IPBlacklist();
    ipBlackList.setService(mockLoginService);
    assertTrue(ipBlackList.login(ip,userName,correctPassword));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void theIPIsBlocked(){
    //test 3 de ramas 
    //tengo que poner 3 veces una contraseña incorrecta, para que se bloquee la ip
    String ip = "192.168.0.1";
    String userName = "agus";
    String wrongPassword1 = "augs";
    String wrongPassword2 = "agsu";
    String wrongPassword3 = "suga";

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);
    String wrongPasswordHash3 = Utils.getPasswordHashMD5(wrongPassword3);

    LoginService mockLoginService = createMock(LoginService.class);

    expect(mockLoginService.login(ip,userName,wrongPasswordHash1)).andReturn(false);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash2)).andReturn(false);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash3)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlackList = new IPBlacklist();
    ipBlackList.setService(mockLoginService);

    assertFalse(ipBlackList.login(ip,userName,wrongPassword1));
    assertFalse(ipBlackList.login(ip,userName,wrongPassword2));
    assertFalse(ipBlackList.login(ip,userName,wrongPassword3));
    assertTrue(ipBlackList.blacklisted(ip));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void twoUnsuccessfulLoginAttempts(){
    //corresponde al test 4 de ramas 
    //la ip es igual a la ultima ingresada, pero todavia no se llego a los 3 intentos fallidos
    String ip = "192.168.0.1";
    String userName = "agus";
    String wrongPassword1 = "augs";
    String wrongPassword2 = "agsu";

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);

    LoginService mockLoginService = createMock(LoginService.class);

    expect(mockLoginService.login(ip,userName,wrongPasswordHash1)).andReturn(false);
    expect(mockLoginService.login(ip,userName,wrongPasswordHash2)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlackList = new IPBlacklist();
    ipBlackList.setService(mockLoginService);

    assertFalse(ipBlackList.login(ip,userName,wrongPassword1));
    assertFalse(ipBlackList.login(ip,userName,wrongPassword2));

    verify(mockLoginService);
    reset(mockLoginService);
  }

  @Test 
  public void twoIncorrectAttemptsWithDifferentIpAddresses(){
    //corresponde al test 5 de ramas 
    //se tienen 2 inicios de sesion incorrectos en distintas ips
    String ip1 = "192.168.0.0";
    String ip2 = "192.168.0.1";
    String userName1 = "agus";
    String userName2 = "messi";
    String wrongPassword1 = "agsu";
    String wrongPassword2 = "cr7";

    String wrongPasswordHash1 = Utils.getPasswordHashMD5(wrongPassword1);
    String wrongPasswordHash2 = Utils.getPasswordHashMD5(wrongPassword2);

    LoginService mockLoginService = createMock(LoginService.class);

    expect(mockLoginService.login(ip1,userName1,wrongPasswordHash1)).andReturn(false);
    expect(mockLoginService.login(ip2,userName2,wrongPasswordHash2)).andReturn(false);

    replay(mockLoginService);

    IPBlacklist ipBlackList = new IPBlacklist();
    ipBlackList.setService(mockLoginService);

    assertFalse(ipBlackList.login(ip1,userName1,wrongPassword1));
    assertFalse(ipBlackList.login(ip2,userName2,wrongPassword2));

    verify(mockLoginService);
    reset(mockLoginService);
  }

}
