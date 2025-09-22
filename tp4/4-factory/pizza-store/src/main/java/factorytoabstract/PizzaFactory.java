package factorytoabstract;

public abstract class PizzaFactory{
  protected abstract VeggiePizza createVeggiePizza();
  protected abstract PepperoniPizza createPepperoniPizza();
  protected abstract ClamPizza createClamPizza();
  protected abstract CheesePizza createCheesePizza();
}

