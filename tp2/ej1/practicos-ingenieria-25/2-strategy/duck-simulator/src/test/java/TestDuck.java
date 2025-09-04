import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDuck {

    @Test
    public void testMallardDuck() {
        Duck mallard = new MallardDuck();
        assertEquals("Quack",mallard.performQuack());
        assertEquals("I'm flying!!",mallard.performFly());
    }

    @Test
    public void testModelDuck() {
        Duck model = new ModelDuck();
        assertEquals("Quack",model.performQuack());
        assertEquals("I can't fly",model.performFly());
    }

    @Test
    public void testModelDuckChangeFlyBehavior() {
        Duck model = new ModelDuck();
        assertEquals("I can't fly",model.performFly());
        model.setFlyBehavior(new FlyRocketPowered());
        assertEquals("I'm flying with a rocket",model.performFly());
    }
    
    @Test 
    public void testPatoCriolloChangeFlyBehavior(){
      Duck criollo = new PatoCriollo();
      assertEquals("I'm flying!!",criollo.performFly());
      criollo.setFlyBehavior(new FlyRocketPowered());
      assertEquals("I'm flying with a rocket",criollo.performFly());
      criollo.setFlyBehavior(new FlyNoWay());
      assertEquals("I can't fly",criollo.performFly());
    }

    @Test 
    public void testGansoChangeQuackBehavior(){
      Duck ganso = new Ganso();
      assertEquals("Mortal Quack!!",ganso.performQuack());
      ganso.setQuackBehavior(new Quack());
      assertEquals("Quack",ganso.performQuack());
    }

    @Test 
    public void testDucksFlockFly(){
      DucksFlock ducks = new DucksFlock();
      ducks.addDuck(new MallardDuck());
      ducks.addDuck(new ModelDuck());
      ducks.addDuck(new PatoCriollo());
      ducks.addDuck(new Ganso());
      String expectedFly = "I'm flying!!\nI can't fly\nI'm flying!!\nI'm flying with a JetPack!!\n";
      assertEquals(expectedFly,ducks.fly());
    }

    @Test 
    public void testDucksFlockQuack(){
      DucksFlock ducks = new DucksFlock();
      ducks.addDuck(new MallardDuck());
      ducks.addDuck(new ModelDuck());
      ducks.addDuck(new PatoCriollo());
      ducks.addDuck(new Ganso());
      String expectedQuack = "Quack\nQuack\nQuack\nMortal Quack!!\n";
      assertEquals(expectedQuack,ducks.quack());
  }

    @Test 
    public void testDuckSimulator(){
      DucksFlock ducks = new DucksFlock();
      ducks.addDuck(new MallardDuck());
      ducks.addDuck(new ModelDuck());
      ducks.addDuck(new PatoCriollo());
      DuckSimulator simulator = new DuckSimulator(ducks);
      simulator.addDuck(new Ganso());
      String expectedSimulate = "I'm flying!!\nI can't fly\nI'm flying!!\nI'm flying with a JetPack!!\nQuack\nQuack\nQuack\nMortal Quack!!\n";
      assertEquals(expectedSimulate,simulator.simulate());
    }
}
