package ssp;
// Problem Title :-> Search in a rotated sorted array
// Approach :-> Using single pass of Binary Search.
// Complexity Analysis :-> Time Complexity is O(log n) & Space Complexity O(1) as no extra space is required.
public class SSP_Problem_03 {
	/*
	 * Returns index of key in a[1..h] if key is present,
	 * otherwise returns -1.
	 */
	static int search(int[] a, int l, int h, int key) {
		if(l > h) 		return -1;
		int mid = (l + h) / 2;
		if(a[mid] == key) 		return mid;
		
		/* If a[1...mid] first sub-array is sorted */
		if(a[l] <= a[mid]) {
			if(key >= a[l] && key <= a[mid])
				return search(a, l, mid - 1, key);
			return search(a, mid + 1, h, key);
		}
		
		/*
		 * If a[1..mid] first sub-array is not sorted,
		 * then a[mid...h] must be sorted sub-array
		 */
		if(key >= a[mid] && key <= a[h])
			return search(a, mid + 1, h, key);
		
		/*
		 * if key not lies in first half sub-array,
		 * Divide other half into two sub-arrays,
		 * such that we can quickly check if key lies in other half 
		 */
		return search(a, l, mid - 1, key);
	}
	// Driver Code
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		int n = a.length;
		int key = 6;
		int i = search(a, 0, n - 1, key);
		if(i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}
