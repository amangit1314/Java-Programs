package babbarArrayProblems;

/**
 * Array Problem 1: Reverse an Array
 * --------------------------------
 * This file contains multiple approaches to reverse an array.
 *
 * Approaches Covered:
 * 1. Brute Force (Using a temporary array)
 * 2. In-place reversal (Optimal approach)
 *
 * For each approach, time complexity and explanation are provided.
 *
 * Example Array: {1, 2, 3, 4, 5, 6}
 *
 * Output:
 *   Original array: 1 2 3 4 5 6
 *   Reversed array: 6 5 4 3 2 1
 */
public class Array_Problem_1 {

	/**
	 * Approach 1: Brute Force (Using a temporary array)
	 * ------------------------------------------------
	 * Create a new array and copy elements in reverse order.
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static int[] reverseArrayBruteForce(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[n - 1 - i];
		}
		return temp;
	}

	/**
	 * Approach 2: In-place Reversal (Optimal)
	 * ---------------------------------------
	 * Swap elements from start and end, moving towards the center.
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static void reverseArrayInPlace(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Utility method to print an array.
	 */
	public static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/**
	 * Main method to demonstrate all approaches with example array.
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.println("Original array:");
		printArray(arr, 6);

		// Brute Force
		int[] reversedBrute = reverseArrayBruteForce(arr.clone());
		System.out.println("Reversed array (Brute Force):");
		printArray(reversedBrute, 6);

		// In-place
		int[] arrInPlace = arr.clone();
		reverseArrayInPlace(arrInPlace, 0, 5);
		System.out.println("Reversed array (In-place):");
		printArray(arrInPlace, 6);
	}
}
