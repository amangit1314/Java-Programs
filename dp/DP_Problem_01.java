package dp;

import java.util.*;
/*
 * Problem Title :- Coin Change Problem
 */
public class DP_Problem_01 {

	static int minCoins(int n, int a[], int dp[]) {
		// Base Case
		if(n == 0)	return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i<a.length; i++) {
			
			if(n - a[i] >= 0) {
				int subAns = 0;
				// If the value of arrays.array at this index is not empty then put the value in subAns variable.
				if(dp[n-a[i]] != -1) 	subAns = dp[n-a[i]];
				// else it will case minCoins function recursively for n-a[i] position
				else 	subAns = minCoins(n-a[i],a, dp);
				// if conditions satisfies then put subAns + 1 in ans variable.
				if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) 	ans = subAns + 1;
			}
		}
		// now return the answer
		return dp[n] = ans;
	}
	
	public static void main(String[] args) {

		int n = 18;
		int a[] = {7, 5, 1};
		int dp[] = new int[n+1];
		
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		int ans = minCoins(n, a, dp);
		System.out.println(ans);
		
		for(int x: dp) 
			System.out.println(x + " ");
	}
}
