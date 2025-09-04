import java.util.List;
import java.util.ArrayList;

public class DuckSimulator {
 
  private DucksFlock ducks;

  public DuckSimulator(DucksFlock ducks){
    this.ducks = ducks; 
  }

  public void addDuck(Duck duck){
    ducks.addDuck(duck);
  }

  public String simulate(){
    String answer = "";
    answer += ducks.fly();
    answer += ducks.quack();
    return answer;
  }

}
