// Smallest sum contiguous subarray

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_36 {
    public static int smallestSumContiguousSubarray(int[] arr) {
        int minSoFar = arr[0];
        int minEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = smallestSumContiguousSubarray(arr);
        System.out.println("The smallest sum contiguous subarray is: " + result);
    }
}
       