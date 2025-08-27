package org.example;
import java.util.Map;
import java.util.HashMap;

public class Game {
    
    private int currentScore;
    private int currentFrame;
    private int rollCount;
    private int[] scoresForRoll;
    private Map<Integer,Integer> scoresForFrame;

    public Game(){
        currentFrame = 1;
        scoresForRoll = new int[22]; //en 0 y 1 estan los tiros 
                                      //del frame 1, en 2 y 3 los 
                                      //tiros del frame 2, ...
                                      //en 20 y 21 estan los 2 tiros 
                                      //extra en caso de usarse
        scoresForFrame = new HashMap<>(); 
        for(int i = 1; i <= 10; i++) scoresForFrame.put(i,0);
    } 

    public void roll(int pins){
        if(pins < 0 || pins > 10) throw new IllegalArgumentException();
        
        //si estoy en el segundo tiro de un frame, 
        //solo puedo hacer un tiro de max 10 - anterior tiro 
        if(rollCount % 2 != 0 && pins > (10 - scoresForRoll[rollCount - 1])){ 
            throw new IllegalStateException();
        }
        
        //puedo acceder a un frame 11 solo si en el 10 se tiraron 10
        if(currentFrame > 10 && scoresForFrame.get(10) != 10) 
            throw new IllegalStateException();
        
        //si estoy en el frame 11 porque en el 10 hubo spare/strike
        if(currentFrame == 11){
            if(scoresForRoll[19] != 0 && rollCount == 20){ //si hay spare 
                scoresForRoll[20] = pins; //guardo la cantidad de 
                                          //bolos q tiro
            }else if(scoresForRoll[19] != 0 && rollCount > 20){
                //en caso de hacer spare en el ultimo frame, 
                //solo puedo hacer un tiro mas
                throw new IllegalStateException();
            }
                //en caso de tener strike en el ultimo frame, 
                //puedo usar 2 tiradas mas
            else if(scoresForRoll[19] == 0 && 19 < rollCount && rollCount < 22){
                scoresForRoll[rollCount] = pins; 
                rollCount++;
            }else if(scoresForRoll[19] == 0 && rollCount >= 22){
                //en caso de tener un strike en el ultimo frame, 
                //no puedo usar mas de 2 tiradas 
                throw new IllegalStateException();
            }
        }else{

            //la puntuacion del frame actual la incremento con pins
            int currentFrameScore = scoresForFrame.get(currentFrame); 
            currentFrameScore += pins;
            scoresForFrame.put(currentFrame,currentFrameScore);
            
            //guardo la cantidad de bolos que tire en la rollCount tirada
            scoresForRoll[rollCount] = pins;

            boolean changeFrame = rollCount % 2 != 0;

            //si en el primer tiro del frame saque 10, no hay segundo tiro 
            if(!changeFrame && pins == 10){
                rollCount += 2;
                currentFrame++;
            }else{
                rollCount++;
            }
            
            if(changeFrame) //si se hicieron dos tiros, cambio de frame 
                currentFrame++;
        }
    }
    
    public int score(){
        for(int i = 1; i <= scoresForFrame.keySet().size(); i++){
            int currentFrameScore = scoresForFrame.get(i);
            currentScore += currentFrameScore;
            //si en un frame tire 10 y el segundo tiro del frame no es 0,
            //porque si lo fuese, hubiese sido un strike,
            //sumo la cantidad de bolos del sig tiro
            if(currentFrameScore == 10 && scoresForRoll[(i * 2)-1] != 0){
                currentScore += scoresForRoll[i*2];
            } //si en un frame tire 10 y el segundo tiro del frame es 0, 
              //es decir, tenemos un strike, 
              //sumo la cantidad de bolos de los siguientes 2 tiros
            else if(currentFrameScore == 10 && scoresForRoll[(i*2)-1] == 0){
                currentScore += scoresForRoll[i*2];
                currentScore += scoresForRoll[(i*2) + 1];
            }
            
        }
        return currentScore;
    }
  
    public int[] getScoresForRoll(){
      return scoresForRoll;
    } 
}
