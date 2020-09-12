package basicProblems;
import java.util.*;
public class Prime_Number_Or_Not {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isPrime = true;
		for(int i=2;i<n;i++) {
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.print(" is Prime " + isPrime);
		

	}

}
