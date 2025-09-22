package factorytoabstract;

public class NYPizzaStore extends PizzaStore {

  public NYPizzaStore(){
    factory = new NYPizzaFactory();
  }

}
