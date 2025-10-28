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


}
