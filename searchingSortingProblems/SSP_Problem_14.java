package searchingSortingProblems;

import java.util.Arrays;

public class SSP_Problem_14 {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] merged = new int[m + n]; // Create a new array to store the merged elements

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from the non-empty array (if any)
        while (i < m) {
            merged[k++] = arr1[i++];
        }
        while (j < n) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void mergeArraysInPlace(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // Copy remaining elements from arr2 (if any)
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };
        int[] merged = mergeArrays(arr1, arr2);
        System.out.println("Merged array: " + Arrays.toString(merged));
    }
}
