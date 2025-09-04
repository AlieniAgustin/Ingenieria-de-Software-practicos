public class Ganso extends Duck{

  public Ganso(){
    flyBehavior = new FlyWithJetPack();
    quackBehavior = new MortalQuack();
  }

  public String display(){
    return "I'm a dangerous Ganso";
  }

}
