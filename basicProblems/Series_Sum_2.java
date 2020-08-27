package basicProblems;
import java.util.Scanner;

/* This series is also known as TAYLOR series*/
// program to demonstrate series sum of "1 + 1/2 + 1/3 + 1/4 + 1/5 + ...1 /n" this before mentioned series

public class Series_Sum_2 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		float result = 0;
		
		for(float i=1;i<=n;i++) {
			
			if(i%2==0) {
				result -= 1/i;
			}
			
			else {
				result += 1/i;
			}
			
			System.out.println(result);
		}
		
	}

}
