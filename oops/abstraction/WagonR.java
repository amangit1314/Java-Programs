package oops.abstraction;

public class WagonR extends Car{

	@Override
	public void accelerate() {
		System.out.println("WagonR is accelerating");
	}
	
	@Override
	public void apply_break() {
		System.out.println("break is applied in WagonR");
	}
}
