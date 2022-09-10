package arrays;
/* 
 * Problem Title :-> 
 * Find if there is any sub arrays.array with sum equal to 0
 */

import java.util.*;

/*
 *  Generalisation
 *	a[2, 3, -1, -2, 4, 5]; -> The arrays.array
 * 	here their are n^2 + 1 sub arrays, in an arrays.array of any size n.
 * now the sub arrays.array of have a sum equal to zero is from index a[1] to index a[3] in this case.
 */

public class Array_Problem_21 {
	static Boolean subArrayExists(int[] a) {
		// Creates an empty hash set h_s
		Set<Integer> hs = new HashSet<>();
		// Initialise sum of elements
		int sum = 0;
		// Traverse through the given arrays.array
		for(int i = 0; i < a.length; i++) {
			// Add current element to sum
			sum += a[i];
			/*
			 * Return true in following cases
			 * a). Current element is 0
			 * b). sum of elements from 0 to i is 0
			 * c). sum is already present in hash map
			 */
			if(a[i] == 0 || sum == 0 || hs.contains(sum)) return true;
			// Add sum to hash set
			hs.add(sum);
		}
		// We reach here only when there is no sub_array with 0 sum
		return false;
	}
	// Driver Code
	public static void main(String[] args) {
		int[] a = {2, 3, -1, -2, 4, 5};
		if(subArrayExists(a))
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Such Sub Array Exists!");
	}
}
