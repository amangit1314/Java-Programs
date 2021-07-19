package arrays;

//Java program to reverse the given array
public class Array_Problem_1 {

	static void revereseArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
	}

	/*
	 * Utility that prints out an array on a line
	 */
	static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	// Driver code
	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 4, 5, 6 };
		printArray(arr, 6);
		revereseArray(arr, 0, 5);
		System.out.print("Reversed array is \n");
		printArray(arr, 6);

	}

}
