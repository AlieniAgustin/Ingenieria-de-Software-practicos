package factorytoabstract;

public class NYPizzaStore extends PizzaStore {

	public VeggiePizza createVeggiePizza(){
    return new NYStyleVeggiePizza();
  }

	public PepperoniPizza createPepperoniPizza(){
    return new NYStylePepperoniPizza();
  }

  public ClamPizza createClamPizza(){
    return new NYStyleClamPizza();
  }

	public CheesePizza createCheesePizza(){
    return new NYStyleCheesePizza();
  }

}
