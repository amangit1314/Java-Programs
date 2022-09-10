package searchingSortingProblems;

import java.util.*;
import java.lang.*;

// Problem Titile => Find the repeating and missing
 class SSP_Problem_07 {

    static void printTwoElements(int[] arr, int size) {
        int i;
        System.out.println("The repeating element is : ");

        for (i = 0; i < size; i++) {
            // absolute values of every element as an index
            int abs_val = Math.abs(arr[i]);
            // make the value at the index as negative to mark it visited
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            // if something is already marked negative, then this is the repeating element
            else
                System.out.println(abs_val);
        }

        System.out.println("The missing element is : ");
        // traversing the arrays.array again for a positive value
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printTwoElements(arr, n);
    }
}
