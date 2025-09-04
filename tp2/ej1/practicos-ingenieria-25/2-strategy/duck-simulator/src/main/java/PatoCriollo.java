public class PatoCriollo extends Duck {

	public PatoCriollo() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public String display() {
		return "I'm a pato criollo";
	}

}
