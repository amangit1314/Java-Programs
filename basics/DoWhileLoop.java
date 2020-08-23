package basics;

public class DoWhileLoop {
	//method inside which do while loop will occur
	public static void main(String[] args) {
		
	int n = 10;
	//do while loop's do block
	// must executes atleast once
		do {
			System.out.println(" tick " +n);
			n--;
		}while(n>0);// do while loop's while block
	}	// end of main method
}// end of class
