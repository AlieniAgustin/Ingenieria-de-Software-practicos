package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy implements OutputStrategy{

  private String filePath;

  public FileOutputStrategy(String filePath){
    this.filePath = filePath;
  }

  public void showOutput(String output){
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write(output + System.lineSeparator());
    } catch (IOException e) {
      e.printStackTrace();     
    }
  }

}
