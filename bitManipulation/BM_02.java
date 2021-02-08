package bitManipulation;

// Problem Title :-> Find the two non-repeating elements in an array of repeating elements
public class BM_02 {

	// This function sets the values of *x & *y to non-repeating elements in an array a[] of size n
	public static void UniqueNumber(int[] a, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			// X-or all the elements of the array
			// all the elements occur-i-n-g twice will
			// cancel out each other remaining
			// two unique numbers will be x-o-red
			sum = (sum^a[i]);
		}
		
		// Bitwise & the sum with it's 2's Complement 
		// Bitwise & will give us the sum containing 
		// only the rightmost set bit
		sum = (sum &- sum);
		
		// sum1 & sum2 will contain 2 unique elements
		// elements initialized with 0 box number
		// x-o-red with 0 is number itself
		int sum1 = 0;
		int sum2 = 0;
		
		// traversing the array again
		for(int i = 0; i < a.length; i++) {
			
			// Bitwise & the a[i] with the sum
			// Two possibilities either result == 0
			// or result > 0
			if((a[i] & sum) > 0)
				// if result >, 0 then a[i] x-o-red with sum1
				sum1 = (sum1^a[i]);
			else
				// if result == 0 then a[i] x-o-red with sum2
				sum2 = (sum2^a[i]);
		}
		// print the two unique numbers
		System.out.println("The non repeating elements are " + sum1 + " and " +sum2);
	}
	
	public static void main(String[] args) {

		int[] a = new int[] {2, 3, 7, 9, 11, 2, 3, 11};
		int n = a.length;
		UniqueNumber(a, n);
	}

}
