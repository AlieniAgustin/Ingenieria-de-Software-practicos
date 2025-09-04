public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public String display() {
		return "I'm a real Mallard duck";
	}

}
