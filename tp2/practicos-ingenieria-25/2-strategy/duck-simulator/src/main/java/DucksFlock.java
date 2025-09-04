import java.util.List;
import java.util.ArrayList;

public class DucksFlock{

  private List<Duck> ducks;

  public DucksFlock(){
    ducks = new ArrayList<>();
  }

  public void addDuck(Duck duck){
    ducks.add(duck);
  }

  public String fly(){
    String answer = "";
    for(Duck duck : ducks){
      answer += duck.performFly();
      answer += "\n";
    }
    return answer;
  }

  public String quack(){
    String answer = "";
    for(Duck duck : ducks){
      answer += duck.performQuack();
      answer += "\n";
    }
    return answer;
  }

}
