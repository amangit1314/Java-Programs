package babbarArrayProblems;

import java.util.Arrays;

/**
 * Array Problem 3: Find Kth Smallest Element
 * -----------------------------------------
 * This file contains multiple approaches to find the Kth smallest element in an array.
 *
 * Approaches Covered:
 * 1. Brute Force (Sorting)
 * 2. QuickSelect (Randomized)
 * 3. Median of Medians (Optimal deterministic approach)
 *
 * For each approach, time complexity and explanation are provided.
 *
 * Example Array: {12, 3, 5, 7, 4, 19, 26}
 * K = 3
 *
 * Output:
 *   Kth smallest element is 5
 */
public class Array_Problem_3 {

	/**
	 * Approach 1: Brute Force (Sorting)
	 * ---------------------------------
	 * Sort the array and return the Kth element.
	 * Time Complexity: O(n log n)
	 * Space Complexity: O(1) if in-place sort
	 */
	public static int kthSmallestBruteForce(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	/**
	 * Approach 2: QuickSelect (Randomized)
	 * ------------------------------------
	 * Use QuickSelect algorithm to find the Kth smallest element.
	 * Time Complexity: O(n) average case, O(n^2) worst case
	 * Space Complexity: O(1)
	 */
	public static int kthSmallestQuickSelect(int[] arr, int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int pos = partition(arr, l, r);
			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1)
				return kthSmallestQuickSelect(arr, l, pos - 1, k);
			return kthSmallestQuickSelect(arr, pos + 1, r, k - pos + l - 1);
		}
		return Integer.MAX_VALUE;
	}

	static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}


	/**
	 * Approach 3: Median of Medians (Optimal deterministic approach)
	 * ------------------------------------------------------------
	 * Use the median of medians algorithm to find the Kth smallest element.
	 * Time Complexity: O(n) worst case
	 * Space Complexity: O(n)
	 */
	static int findMedian(int[] arr, int i, int n) {
		if (i <= n)
			Arrays.sort(arr, i, n);
		else
			Arrays.sort(arr, n, i);
		return arr[n / 2];
	}

	static int kthSmallest(int[] arr, int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int n = r - l + 1;
			int i;
			int[] median = new int[(n + 4) / 5];
			for (i = 0; i < n / 5; i++)
				median[i] = findMedian(arr, l + i * 5, 5);
			if (i * 5 < n) {
				median[i] = findMedian(arr, l + i * 5, n % 5);
				i++;
			}
			int medOfMed = (i == 1) ? median[i - 1] : kthSmallest(median, 0, i - 1, i / 2);
			int pos = partition(arr, l, r, medOfMed);
			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1)
				return kthSmallest(arr, l, pos - 1, k);
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}
		return Integer.MAX_VALUE;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int l, int r, int x) {
		int i;
		for (i = l; i < r; i++)
			if (arr[i] == x) break;
		swap(arr, i, r);
		i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}


	/**
	 * Main method to demonstrate all approaches with example array.
	 */
	public static void main(String[] args) {
		int[] arr = {12, 3, 5, 7, 4, 19, 26};
		int n = arr.length, k = 3;
		System.out.println("Kth smallest element is " + kthSmallest(arr, 0, n - 1, k));
	}
}
