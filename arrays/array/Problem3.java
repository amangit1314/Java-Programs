package arrays.array;

/*
 * TITLE ==> (Find K^th smallest element)
 *
 * Problem Statement ==>
 * Given an arrays.array[] and a number K where K is smaller than size of arrays.array,
 * the task is to find the K^th the smallest element in the given arrays.array.
 * It is given that all arrays.array elements are distinct.
 */

import java.util.Arrays;
import java.util.Scanner;

class Problem3{
    // int partition(int arrays.array[], int l, int r, int k);
    // A simple function to find median of arr[].
    // This is called only for an arrays.array of size 5 in this program.
    static int findMedian(int[] arr, int i,int n) {
        if(i <= n)
            // Sort the arrays.array
            Arrays.sort(arr, i, n);
        else
            Arrays.sort(arr, n, i);
        return arr[n/2]; // Return middle element
    }

    // Returns k^th the smallest element
    // in arr[l..r] in worst case
    // linear time. ASSUMPTION: ALL
    // ELEMENTS IN ARR[] ARE DISTINCT
    static int kthSmallest(int[] arr, int l, int r, int k)
    {
        // IF k is smaller than the number of elements in arrays.array
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1 ; // Number of elements in arr[l..r]

            // Divide arr[] in groups of size 5,
            // calculate median of every group and store it in median[] arrays.array.
            int i;

            // There will be floor((n+4)/5) groups;
            int []median = new int[(n + 4) / 5];
            for (i = 0; i < n/5; i++)
                median[i] = findMedian(arr,l + i * 5, 5);

            // For last group with less than 5 elements
            if (i*5 < n) {
                median[i] = findMedian(arr,l + i * 5, n % 5);
                i++;
            }

            // Find median of all medians using recursive call.
            // IF median[] has only one element,
            // then there is no need of recursive call
            int medOfMed = (i == 1)? median[i - 1]:
                    kthSmallest(median, 0, i - 1, i / 2);

            // Partition the arrays.array around a random element and get position of pivot element in sorted arrays.array
            int pos = partition(arr, l, r, medOfMed);

            // IF position is same as k
            if (pos-l == k - 1)
                return arr[pos];
            if (pos-l > k - 1)
                // IF position is more, recur for left
                return kthSmallest(arr, l, pos - 1, k);

            // ELSE recur for right sub arrays.array
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // IF k is more than number of elements in arrays.array
        return Integer.MAX_VALUE;
    }

    static void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // It searches for x in arr[l..r], and partition's the arrays.array around x.
    static int partition(int[] arr, int l, int r, int x) {
        // Search for x in arr[l..r] and move it to end
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x) 	break;
        swap(arr, i, r);

        // Standard partition algorithm
        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input Size of Array
        System.out.println("Input total no of element's in the arrays.array ");
        int n = sc.nextInt();
        //Array Input
        System.out.println("Input element's of the arrays.array ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // K Input
        System.out.println("Input K to find out K^th Element ");
        int k = sc.nextInt();
        //"K^th smallest element is " +
        System.out.println(kthSmallest(arr, 0, n - 1, k));
    }
}