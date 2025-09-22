package factorytoabstract;

public class NYPizzaFactory extends PizzaFactory{
  
  protected VeggiePizza createVeggiePizza(){
    return new NYStyleVeggiePizza();
  }

  protected PepperoniPizza createPepperoniPizza(){
    return new NYStylePepperoniPizza();
  }

  protected ClamPizza createClamPizza(){
    return new NYStyleClamPizza();
  }

  protected CheesePizza createCheesePizza(){
    return new NYStyleCheesePizza();
  }

}
