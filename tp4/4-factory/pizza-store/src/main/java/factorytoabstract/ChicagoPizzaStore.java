package factorytoabstract;

public class ChicagoPizzaStore extends PizzaStore {

  public ChicagoPizzaStore(){
    factory = new ChicagoPizzaFactory();
  }

}
