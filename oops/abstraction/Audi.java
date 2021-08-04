package oops.abstraction;

//Audi Class
public class Audi extends Car{
	
	public void accelerate() {
		System.out.println("Audi is accelerating");
	}
	
	@Override
	public void apply_break() {
		System.out.println("Audi is breaking");	
	}
}
