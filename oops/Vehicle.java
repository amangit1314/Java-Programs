package oops;

class transport{
	int wheels;
	transport(){
		wheels = 4;
	}
}

public class Vehicle {

	public static void main(String[] args) {
		
		transport car = new transport();
		System.out.println(car.wheels + " wheels");
		
	}

}
