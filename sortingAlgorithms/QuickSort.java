 package sortingAlgorithms;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    static int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        count++;
    }

    // Function to do left and right partition in the arrays.array
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                count++;
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // A utility function to print arrays.array of size n
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

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
        System.out.println();

        System.out.println("Given Array: ");
        printArray(arr);

        System.out.println();

        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, n - 1);

        System.out.println("Sorted arrays.array: ");
        printArray(arr);

        System.out.println();

        System.out.println("Sorted arrays.array as input: ");
        printArray(arr);

        System.out.println();

        System.out.println("Operations: ");
        System.out.println(count);
    }
}