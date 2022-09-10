package arrays;
/* 
 * Problem Title :-> Find longest consecutive subsequence
 */

import java.util.*;

public class Array_Problem_24 {
	
	static int findLogestSubseq(int[] a, int n) {
		// Sort the arrays.array
		Arrays.sort(a);
		int ans = 0, count = 0;
		
		ArrayList<Integer> v = new ArrayList<>();
		v.add(10);
		
		// Insert repeated elements only once in the vector
		for(int i = 1; i < n; i++) {
			if(a[i] != a[i -1]) 	v.add(a[i]);
		}
		
		// Find the max length by traversing the arrays.array
		for(int i = 0; i < v.size(); i++) {
			// check if the current element is equal to previous element + 1
			if(i > 0 && v.get(i) == v.get(i - 1) + 1)	count++;
			else	count = 1;
			// Update the maximum
			ans = Math.max(ans, count);
		}
		return ans;
	}
	
	// Driver Code
	public static void main(String[] args) {
		int[] a = {1,9,3,10,4,20,2};
		int n = a.length;
		System.out.println("Length of the Longest "+ "contiguous subsequence is " + findLogestSubseq(a, n));
	}
}
