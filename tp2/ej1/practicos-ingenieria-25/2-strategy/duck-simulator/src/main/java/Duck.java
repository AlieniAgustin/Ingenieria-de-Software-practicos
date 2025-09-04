public abstract class Duck {

//cuando se tiene una clase abstracta, no se puede instanciar directamente 

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

  abstract String display(); 

	public String performFly() {
		return flyBehavior.fly();
	}

	public String performQuack() {
		return quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
