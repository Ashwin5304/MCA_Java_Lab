package Program_04;

interface Vehicle{
	void start();
	void stop();
}

abstract class VechicleBase implements Vehicle{
	abstract void drive();
}

class Car extends VechicleBase {
	
	@Override
	public void start() {
		System.out.println("Car is starting");
	}
	
	@Override
	public void drive() {
		System.out.println("Car is driving");
	}
	
	@Override
	public void stop() {
		System.out.println("Car is stopping");
	}
}

class Bike extends VechicleBase {
	
	@Override
	public void start() {
		System.out.println("Bike is starting");
	}
	
	@Override
	public void drive() {
		System.out.println("Bike is driving");
	}
	
	@Override
	public void stop() {
		System.out.println("Bike is stopping");
	}
}

public class Main {
	public static void main(String args[]) {
		
		Vehicle a = new Car();
		
		a.start();
		a.stop();
		
		VechicleBase b = new Car();
		
		b.drive();
		
		Vehicle c = new Bike();
		
		c.start();
		c.stop();
		
		VechicleBase d = new Bike();
		
		d.drive();
	}
	
}
