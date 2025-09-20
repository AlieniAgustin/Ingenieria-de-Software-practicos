package factorymethod;

public class ArgentineCalabresaPizza extends Pizza {

	public ArgentineCalabresaPizza() { 
		name = "Calabresa papi";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Calabresa");
	}
 
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
