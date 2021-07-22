package dp;

/*
 * Problem Title :- Binomial Coefficient Problem
 */

public class DP_Problem_03 {
	// Returns value of Binomial Coefficient C(n,k)
	static int binomialCoeff(int n, int k) {
		//Base Case
		if(k > n)
			return 0;
		if(k == 0 || k == n)
			return 1;
		//Recursion
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n -1 , k);
	}
	
	// Driver Program
	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.printf("Value of C(%d, %d) is %d", n, k, binomialCoeff(n,k));
	}
}
