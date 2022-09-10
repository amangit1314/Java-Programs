package basics.basicProblems;
import java.util.*;

public class Prime_Number_Or_Not {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isPrime = true;
		for(int i = 2; i < n; i++) {
			//checking if the remainder is zero, then isPrime return false
			if(n % i == 0) {
				isPrime = false;	
				break;
			}
			//else isPrime return true
			isPrime = true;
		}
		System.out.print("Is a Prime number: " + isPrime);
	}
}
