package ssp;

// Problem Title :- Find first and last positions of an element in a sorted array
// An optimized approach using binary search in O(n) Time Complexity.
public class SSP_Problem_01 {

	/*
	 * if x is present in a[] then returns the index of 
	 * FIRST occurrence of x in a[0...n-1],
	 * otherwise returns -1.
	 */
	public static int first(int[] a, int low, int high, int x, int n) {
		
		if(high >= low) {
			
			int mid = low + (high - low)/2;
			
			if( (mid == 0 || x > a[mid - 1]) && a[mid] == x)
				return mid;
			
			else if(x > a[mid])
				return  first(a, (mid + 1), high, x, n);
			
			else
				return first(a, low, (mid - 1 ), x, n);
		}
		return -1;
	}
	
	/*
	 * if x is present in a[] then returns the index of 
	 * LAST occurrence of x in a[0..n-1],
	 * otherwise returns -1
	 */
	public static int last(int a[], int low, int high, int x, int n) {
		
		if(high >= low) {
			
			int mid = low + (high - low)/2;
			
			if((mid == n-1 || x < a[mid + 1]) && a[mid] == x)
				return mid;
			
			else if(x < a[mid])
				return last(a, low, (mid - 1), x, n);
			
			else
				return last(a, (mid + 1), high, x, n);
		}
		
		return -1;
	}
	
	// Driver Code
	public static void main(String[] args) {

		int[] a = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
		
		int n = a.length;
		int x = 8;
		
		System.out.println("First Occurence = " + first(a, 0, n - 1, x, n));
		System.out.println("last Occurence = " + last(a, 0, n-1, x, n));
	}

}
