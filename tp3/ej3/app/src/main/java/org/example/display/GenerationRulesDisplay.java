package org.example.display;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import org.example.gameOfLife.GameOfLife;
import org.example.cell.Cell;

public class GenerationRulesDisplay implements Observer,DisplayElement{

  private GameOfLife game;
  private int lastGenBirthCount;
  private int lastGenSurvivalCount;
  private int lastGenDeathCount;
  private float lastGenBirthPercent;
  private float lastGenSurvivalPercent;
  private float lastGenDeathPercent;
  private float avgBirthPercent;
  private float avgSurvivalPercent;
  private float avgDeathPercent;
  private int displayCount;
  private float sumBirthPercent;
  private float sumSurvivalPercent;
  private float sumDeathPercent;

  public GenerationRulesDisplay(GameOfLife game){
    this.game = game;
    this.game.registerObserver(this);
    displayCount = 1;
    avgBirthPercent = 0f;
    avgSurvivalPercent = 0f;
    avgDeathPercent = 0f;
    sumBirthPercent = 0f;
    sumSurvivalPercent = 0f;
    sumDeathPercent = 0f;
  }

  public void update(){
    int numberOfCells = game.getCells().length * game.getCells()[0].length;
    lastGenDeathCount = game.getCellsDied();
    lastGenBirthCount = game.getCellsBorn();
    lastGenSurvivalCount = game.getCellsSurvived();
    lastGenBirthPercent = (float) lastGenBirthCount / numberOfCells;
    lastGenDeathPercent = (float) lastGenDeathCount / numberOfCells;
    lastGenSurvivalPercent = (float) lastGenSurvivalCount / numberOfCells;
    sumBirthPercent += lastGenBirthPercent;
    sumSurvivalPercent += lastGenSurvivalPercent;
    sumDeathPercent += lastGenDeathPercent;
    avgBirthPercent = sumBirthPercent / displayCount;
    avgSurvivalPercent = sumSurvivalPercent / displayCount;
    avgDeathPercent = sumDeathPercent / displayCount;
    display();
    displayCount++;
  }

  public void display(){
    DecimalFormat df = new DecimalFormat("0.00");
    String output = "Display " + displayCount + ": \n";
    output += "Last gen: Alive: " + df.format(lastGenSurvivalPercent) + ", Born: " + df.format(lastGenBirthPercent) + ", Died: " + df.format(lastGenDeathPercent) + "\n";
    output += "Average: Alive: " + df.format(avgSurvivalPercent) + ", Born: " + df.format(avgBirthPercent) + ", Died: " + df.format(avgDeathPercent) + "\n"; 
    System.out.print(output);
  }

}
