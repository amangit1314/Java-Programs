package bitManipulation;
/*	
 * Problem Title :- Find the two non-repeating elements in an arrays.array of repeating elements
 */
public class BM_02 {

	/*
	 * This function sets the values of *x & *y to non-repeating elements in an arrays.array a[] of size n
	 */
	public static void TwoUniqueNumbers(int[] a, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			// XOR all the elements of the arrays.array
			// all the elements occur-ing twice will
			// cancel out each other remaining
			// two unique numbers will be xor'ed
			sum = (sum^a[i]);
		}
		sum = (sum &- sum);
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < a.length; i++) {
			if((a[i] & sum) > 0) {
				sum1 = (sum1 ^ a[i]);
			}else {
				sum2 = (sum2 ^ a[i]);
			}
		}
		System.out.println("The non-repeating elements are " + sum1 + " and " + sum2);
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {2,3,7,9,11,2,3,11};
		int n = a.length;
		TwoUniqueNumbers(a, n);
	}

}
