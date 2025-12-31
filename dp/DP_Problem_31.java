// Min removals from array to make max - min <= K

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_31 {
    public static int minRemovalsToSatisfyCondition(int[] arr, int n, int K) {
        Arrays.sort(arr);
        int minRemovals = n; // Initialize with maximum possible removals

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && arr[j] - arr[i] <= K) {
                j++;
            }
            // Elements between i and j-1 satisfy the condition
            int removals = n - (j - i);
            minRemovals = Math.min(minRemovals, removals);
        }

        return minRemovals;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int K = scanner.nextInt();

        int result = minRemovalsToSatisfyCondition(arr, n, K);
        System.out.println("Minimum number of removals to satisfy max - min <= " + K + " is: " + result);
    }
}
