package org.example;

public class MockOutputStrategy implements OutputStrategy{

  private String lastOutput;

  public MockOutputStrategy(){ }

  public void showOutput(String output){
    this.lastOutput = output;
  }

  public String getLastOutput(){
    return this.lastOutput;
  }

}

