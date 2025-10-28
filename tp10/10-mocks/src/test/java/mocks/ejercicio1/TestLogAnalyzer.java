package mocks.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogAnalyzer{

  @Test 
  public void analyzeWithValidFileName(){
    IWebService mockWebService = createMock(IWebService.class);
    IEmailService mockEmailService = createMock(IEmailService.class);

    replay(mockWebService,mockEmailService); //las expectativas ya se definieron (no hay ninguna)

    LogAnalyzer logAnalyzer = new LogAnalyzer();
    logAnalyzer.setWebService(mockWebService);
    logAnalyzer.setEmailService(mockEmailService);
    String filename = "elArchivoDelPapu";
    logAnalyzer.analyze(filename);

    verify(mockWebService,mockEmailService); //verificar que se hicieron las llamadas esperadas
    reset(mockWebService,mockEmailService); //reinicia los mocks
  }

  @Test 
  public void analyzeWithInvalidFileNameWithoutException(){
    IWebService mockWebService = createMock(IWebService.class);
    IEmailService mockEmailService = createMock(IEmailService.class);

    mockWebService.logError("Filename too short:elPapu");
    expectLastCall();

    replay(mockWebService,mockEmailService); //ya defini las expectativas 

    LogAnalyzer logAnalyzer = new LogAnalyzer();
    logAnalyzer.setWebService(mockWebService);
    logAnalyzer.setEmailService(mockEmailService);
    String filename = "elPapu";
    logAnalyzer.analyze(filename);

    verify(mockWebService,mockEmailService); //verifico que se hicieron las llamadas correspondientes
    reset(mockWebService,mockEmailService);
  }

  @Test 
  public void analyzeWithInvalidFileNameWithException(){
    IWebService mockWebService = createMock(IWebService.class);
    IEmailService mockEmailService = createMock(IEmailService.class);

    mockWebService.logError("Filename too short:elPapu");
    expectLastCall().andThrow(new RuntimeException("Error"));
    mockEmailService.sendEmail("a","subject","Error");
    expectLastCall();

    replay(mockWebService,mockEmailService); //ya defini las expectativas 

    LogAnalyzer logAnalyzer = new LogAnalyzer();
    logAnalyzer.setWebService(mockWebService);
    logAnalyzer.setEmailService(mockEmailService);
    String filename = "elPapu";
    logAnalyzer.analyze(filename);

    verify(mockWebService,mockEmailService); //veo si se hicieron las llamadas esperadas 
    reset(mockWebService,mockEmailService);
  }

}


