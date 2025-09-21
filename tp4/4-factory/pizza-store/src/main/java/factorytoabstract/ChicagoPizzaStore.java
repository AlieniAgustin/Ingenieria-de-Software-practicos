package factorytoabstract;

public class ChicagoPizzaStore extends PizzaStore {

	public VeggiePizza createVeggiePizza(){
    return new ChicagoStyleVeggiePizza();
  }

	public PepperoniPizza createPepperoniPizza(){
    return new ChicagoStylePepperoniPizza();
  }

  public ClamPizza createClamPizza(){
    return new ChicagoStyleClamPizza();
  }

	public CheesePizza createCheesePizza(){
    return new ChicagoStyleCheesePizza();
  }

}
