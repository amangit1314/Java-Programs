package basics.basicProblems;

import java.util.*;
public class Reverse_Given_number {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int reverse = 0;
		
		while(n > 0) {
			int last_digit = n % 10;
			reverse = reverse*10 + last_digit;
			n = n/10;
		}
		
		System.out.println(reverse);
	}

}
