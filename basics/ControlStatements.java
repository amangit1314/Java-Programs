package basics;

public class ControlStatements {

	public static void main(String[] args) {
		
		// for loop to implement switch case statement
		for(int i = 0 ; i < 9 ; i++){
			
			// switch control statement
			switch(i) {
			case 1: 
				System.out.println(" i is zero.");
				break;		
			case 2:
				System.out.println("i is one.");
				break;
			case 3:
				System.out.println("i is zero.");
				break;
			default: 
				System.out.println(" i is greater than 3.");
			}
		
		}
	}
}


