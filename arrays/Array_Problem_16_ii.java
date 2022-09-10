package arrays;

import java.util.Arrays;

/*
 *  Problem Title :-> Count Inversion's in arrays.array (By Method 2 : Using Enhance Merge Sort)
 */
public class Array_Problem_16_ii {

	private static int mergeAndCount(int[] a, int l, int m, int r) {
		
		// Left sub-arrays.array
		int[] left = Arrays.copyOfRange(a, l, m + 1);
		
		// Right sub-arrays.array
		int[] right = Arrays.copyOfRange(a, m + 1, r + 1);
		
		int i = 0, j = 0, k = 1, swaps = 0;
		
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j])
				a[k++] = left[i++];
			else {
				a[k++] = right[j++];
				swaps += (m + 1) - (l + i);
			}
		}
		
		while(i < left.length)
			a[k++] = left[i++];
		
		while(j < right.length)
			a[k++] = right[j++];
		
		return swaps;
	}
	
	private static int mergeSortAndCount(int[] a, int l, int r) {
		// keeps track of the inversion count at a particular node of the recursion tree
		int count = 0;
		
		if(l < r) {
			int m = (l + r)/2;
			// Total inversion count = left sub-arrays.array count + right sub-arrays.array count + merge count
			// Left sub-arrays.array count
			count += mergeSortAndCount(a, l, m);
			// right sub-arrays.array count
			count += mergeSortAndCount(a, m + 1, r);
			// Merge count
			count += mergeAndCount(a, l, m, r);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 20, 6, 4, 5};
		System.out.println(mergeSortAndCount(a, 0, a.length - 1));
	}

}
