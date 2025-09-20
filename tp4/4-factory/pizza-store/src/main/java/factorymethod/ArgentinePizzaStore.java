package factorymethod;

public class ArgentinePizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("fugazzeta")) {
			return new ArgentineFugazzetaPizza();
		} else if (item.equals("calabresa")) {
			return new ArgentineCalabresaPizza();
		} else return null;
	}
}
