package basics.basicProblems;
import java.util.*;

public class Series_Sum_1 {

	public static void main(String[] args) {
		
		//taking user input
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float result = 0;
		for(float i = 1; i <= n; i++)
			result += 1/i;
		System.out.println(result);
	}
}
