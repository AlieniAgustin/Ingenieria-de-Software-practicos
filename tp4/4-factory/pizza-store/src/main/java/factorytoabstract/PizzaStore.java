package factorytoabstract;

public abstract class PizzaStore {
 
	abstract VeggiePizza createVeggiePizza();
	abstract PepperoniPizza createPepperoniPizza();
  abstract ClamPizza createClamPizza();
	abstract CheesePizza createCheesePizza();

	public Pizza orderPizza(String type) {
    Pizza pizza;
    if(type.equals("veggie"))
      pizza = createVeggiePizza();
    else if(type.equals("pepperoni"))
      pizza = createPepperoniPizza();
    else if(type.equals("clam"))
      pizza = createClamPizza();
    else if(type.equals("cheese"))
      pizza = createCheesePizza();
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
