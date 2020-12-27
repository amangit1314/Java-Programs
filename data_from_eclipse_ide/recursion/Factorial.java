package recursion;
import java.util.Scanner;

public class Factorial {
	public static long multiplyNumbers(int num)
	{
	        if (num >= 1)
	            return num * multiplyNumbers(num - 1);
	        else
	            return 1;
	}
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		 int num = sc.nextInt();
	        long factorial = multiplyNumbers(num);
	        System.out.println("Factorial of " + num + " = " + factorial);
	}
	
}
