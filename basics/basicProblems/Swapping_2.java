package basics.basicProblems;

/*
 * swap two given numbers without using third variable
 */

public class Swapping_2 {

	public static void main(String[] args) {
		
		int a = 20;
		int b = 40;
		
		System.out.println("Number's before swapping: " + "a = " + a + "," + " b =" + " " + b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("Number's after  swapping: " + "a = " + a + "," + " b =" + " " + b);
		
	}

}
