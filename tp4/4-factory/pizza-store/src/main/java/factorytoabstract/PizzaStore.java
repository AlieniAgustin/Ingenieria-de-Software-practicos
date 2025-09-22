package factorytoabstract;

public abstract class PizzaStore {
 
  protected PizzaFactory factory;

	public Pizza orderPizza(String type) {
    Pizza pizza;
    if(type.equals("veggie"))
      pizza = factory.createVeggiePizza();
    else if(type.equals("pepperoni"))
      pizza = factory.createPepperoniPizza();
    else if(type.equals("clam"))
      pizza = factory.createClamPizza();
    else if(type.equals("cheese"))
      pizza = factory.createCheesePizza();
    else 
      throw new IllegalArgumentException();
		
    System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
