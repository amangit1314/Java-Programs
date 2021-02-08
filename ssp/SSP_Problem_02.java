package ssp;

// Problem Title :-> Find a Fixed Point (Value equal to index) in a given array
public class SSP_Problem_02 {
	static int binarySearch(int[] a, int low, int high) {
		
		if(high >= low) {
			
			/* low + (high - low)/2;*/
			int mid = (low + high)/2;
			
			if(mid == a[mid])
				return mid;
			
			if(mid > a[mid])
				return binarySearch(a, (mid + 1), high);
			
			else
				return binarySearch(a, low, (mid - 1));
		}
		/* Return -1 if there is no Fixed Point */
		return -1;
	}
	// Driver Code
	public static void main(String[] args) {
		int[] a= {-10, -1, 0, 3, 10, 11, 30, 50, 100};
		int n = a.length;
		System.out.println("Fixed Point is " + binarySearch(a, 0, n-1));
	}
}
