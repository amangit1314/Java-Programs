package basicProblems;
import java.util.*;
public class X_raisedTo_power_Y {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = 1;
		for(int i=0;i<b;i++) {
			result*=a;
		}
		System.out.println(result);
	}

}
