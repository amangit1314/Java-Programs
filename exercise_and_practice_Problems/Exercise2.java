package exercise_and_practice_Problems;
import java.util.Scanner;

/*
 * Take an array as input & print all of its content at particular index wise
 */

public class Exercise2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n,sum =0;
			
			System.out.println("Enter no. of elements you want in array:");
			n = sc.nextInt();
			
			int A[] =  new int[n];
			System.out.println("Enter all the elements: ");
			
			for(int i=0;i<n;i++) {
				A[i] = sc.nextInt();
				sum = sum + A[i];
			}
			
			for(int i=0;i<=n-1;i++) {
				System.out.println("Element at particular index:");
				System.out.println(A[i]);
			}
			
		}
		
	}

}
