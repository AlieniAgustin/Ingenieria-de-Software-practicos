package factorymethod;

public class ArgentineFugazzetaPizza extends Pizza {

	public ArgentineFugazzetaPizza() { 
		name = "Fugazza peronista";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Onion");
	}
 
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
