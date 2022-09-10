package arrays;

/* Problem Title :-> Three way partitioning of an arrays.array around a given value */
public class Array_Problem_33 {

	// partition a[0..n-1] around [lowVal, highVal] 
	public static void threeWayPartition(int[] a, int lowVal, int highVal) {
		int n = a.length;
		// Initialize ext available positions for smaller (than range) & greater element.
		int start = 0, end = n - 1;
		// Traverse elements from left
		for(int i = 0; i <= end;) {
			// If current element is smaller than range, put it on next available smaller position.
			if(a[i] < lowVal) {
				int temp = a[start];
				a[start] = a[i];
				a[i] = temp;
				start++;
				i++;
			}
			
			// If current element is greater than range, put it on next available greater position.
			else if(a[i] > highVal) {
				int temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end--;
			}
			
			else	i++;
		}
	}
	
	public static void main(String[] args) {
		 int[] a = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		 threeWayPartition(a, 10, 20);
		 System.out.println("Modified Array");
		 for(int i = 0; i < a.length; i++) {
			 System.out.println(a[i] + " ");
		 }
	}

}
