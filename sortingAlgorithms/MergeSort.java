package sortingAlgorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {

    int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max15011520
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    void merge(int[] arr, int l, int m, int r) {

        // Find sizes of two sub arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
        }


        for (int j = 0; j < n2; ++j){
            R[j] = arr[m + 1 + j];

        }

        // Merge the temp arrays

        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub arrays.array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
            count++;
        }

        // Copy remaining elements of L[] (Left arrays.array) if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            count++;
//251024
        }

        // Copy remaining elements of R[] (Right arrays.array) if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            count++;
        }
    }

    // Main function that sorts arr[l..r] (left to right) using merge()
    void sort(int[] arr, int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = l+(r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print arrays.array of size n
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {

        int Min = 1, Max = 100;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getRandomValue(Min, Max);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted arrays.array");
        printArray(arr);
        System.out.println();

        System.out.println("Operations");
        System.out.println(ob.count);
    }
}
