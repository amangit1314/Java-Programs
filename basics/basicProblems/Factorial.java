package basics.basicProblems;
import java.util.*;

public class Factorial {
	
	public static void main(String[] args) {
		
		int fact=1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = n ; i >= 1 ; i--) {
			fact = fact*i;
		}
		System.out.println("fact of " + n + " is " + fact );
	}
}


