package factorytoabstract;

public class ChicagoPizzaFactory extends PizzaFactory{
  
  protected VeggiePizza createVeggiePizza(){
    return new ChicagoStyleVeggiePizza();
  }

  protected PepperoniPizza createPepperoniPizza(){
    return new ChicagoStylePepperoniPizza();
  }

  protected ClamPizza createClamPizza(){
    return new ChicagoStyleClamPizza();
  }

  protected CheesePizza createCheesePizza(){
    return new ChicagoStyleCheesePizza();
  }

}
