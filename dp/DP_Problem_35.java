// Largest sum contiguous subarray

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_35 {
    public static int largestSumContiguousSubarray(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
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

        int result = largestSumContiguousSubarray(arr);
        System.out.println("The largest sum contiguous subarray is: " + result);
    }
}
       