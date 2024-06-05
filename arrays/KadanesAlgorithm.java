package arrays;
import java.util.*;

/*
 * Kadane's Algorithm to find the maxSubarray Sum in O(n)[Linear Time Complexity]
 */

public class KadanesAlgorithm {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements in the array: ");
            int numElements = scanner.nextInt();

            int[] inputArray = new int[numElements];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < numElements; i++) {
                inputArray[i] = scanner.nextInt();
            }

            int maximumSubarraySum = findMaximumSubarraySum(inputArray);
            System.out.println("Maximum subarray sum: " + maximumSubarraySum);
        }
    }

    public static int findMaximumSubarraySum(int[] array) {
        int currentSubarraySum = 0;
        int maximumSumSoFar = Integer.MIN_VALUE;  // Initialize to minimum possible value

        for (int element : array) {
            currentSubarraySum += element;

            if (currentSubarraySum < 0) {
                currentSubarraySum = 0;  // Start a new subarray if sum becomes negative
            }

            maximumSumSoFar = Math.max(maximumSumSoFar, currentSubarraySum);
        }

        return maximumSumSoFar;
    }
}
