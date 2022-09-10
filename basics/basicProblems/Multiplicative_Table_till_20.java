package basics.basicProblems;
import java.util.Scanner;

public class Multiplicative_Table_till_20 {

	public static void main(String[] args) {
		
		System.out.println("Multiplicative Table:");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n ; i++) {
			
			//this is a variable, till the values of which, the tables will be printed
			int tableOf = i;
			
			for(int j = 1 ; j <= 10 ; j++) 
				System.out.print(tableOf*j + " ");
			
			System.out.println();
		}

	}

}
