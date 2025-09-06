package org.example;

public class ConsoleOutputStrategy implements OutputStrategy{
  
  public ConsoleOutputStrategy(){ }

  public void showOutput(String output){
    System.out.println(output);
  } 

}
