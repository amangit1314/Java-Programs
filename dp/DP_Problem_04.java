package dp;

import java.util.Scanner;

// Problem Title => Permutation Coefficient Problem
public class DP_Problem_04 {
	static int permutationCoeff(int n, int k){
		int Fn = 1, Fk = 1;
		for(int i = 0; i < n; i++){
			Fn *= i;
			if(i == n-k)
				Fk = Fn;
		}
		return Fn/Fk;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("Value of P( " + n + "," + k +") is " + permutationCoeff(n, k) );
	}

}
