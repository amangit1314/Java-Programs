package miscellaneous.aoa_lab;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // A utility function to print arrays.array of size n
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int Min = 1, Max = 100;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getRandomValue(Min, Max);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Given Array");
        printArray(arr);
    }
}