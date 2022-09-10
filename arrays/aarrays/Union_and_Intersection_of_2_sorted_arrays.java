package arrays.aarrays;

import java.util.Arrays;

public class Union_and_Intersection_of_2_sorted_arrays {

        void printUnion(int[] arr1, int[] arr2, int m, int n) {
            // Before finding union, make sure arr1[0..m-1]
            // is smaller
            if (m > n) {
                int[] tempp = arr1;
                arr1 = arr2;
                arr2 = tempp;

                int temp = m;
                m = n;
                n = temp;
            }

            // Now arr1[] is smaller
            // Sort the first arrays.array and print its elements
            // (these two steps can be swapped as order in
            // output is not important)
            Arrays.sort(arr1);
            for (int i = 0; i < m; i++)
                System.out.print(arr1[i] + " ");

            // Search every element of bigger arrays.array in smaller
            // arrays.array and print the element if not found
            for (int i = 0; i < n; i++) {
                if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1)
                    System.out.print(arr2[i] + " ");
            }
        }

        // Prints intersection of arr1[0..m-1] and arr2[0..n-1]
        void printIntersection(int[] arr1, int[] arr2, int m, int n)
        {
            // Before finding intersection, make sure arr1[0..m-1] is smaller
            if (m > n) {
                int[] tempp = arr1;
                arr1 = arr2;
                arr2 = tempp;

                int temp = m;
                m = n;
                n = temp;
            }

            // Now arr1[] is smaller Sort smaller arrays.array arr1[0..m-1]
            Arrays.sort(arr1);

            // Search every element of bigger arrays.array in smaller arrays.array and print the element if found
            for (int i = 0; i < n; i++) {
                if (binarySearch(arr1, 0, m - 1, arr2[i]) != -1)
                    System.out.print(arr2[i] + " ");
            }
        }

        // A recursive binary search function. It returns location of x in given arrays.array arr[l..r] is present, otherwise -1
        int binarySearch(int[] arr, int l, int r, int x) {
            if (r >= l) {
                int mid = l + (r - l) / 2;

                // If the element is present at the middle
                // itself
                if (arr[mid] == x)
                    return mid;

                // If element is smaller than mid, then it can
                // only be present in left subarray
                if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);

                // Else the element can only be present in right
                // subarray
                return binarySearch(arr, mid + 1, r, x);
            }

            // We reach here when element is not present in
            // arrays.array
            return -1;
        }

        // Driver code
        public static void main(String[] args) {

            Union_and_Intersection_of_2_sorted_arrays u_i= new Union_and_Intersection_of_2_sorted_arrays();

            int[] arr1 = { 7, 1, 5, 2, 3, 6 };
            int[] arr2 = { 3, 8, 6, 20, 7 };

            int m = arr1.length;
            int n = arr2.length;

            // Function call
            System.out.println("Union of two arrays is ");
            u_i.printUnion(arr1, arr2, m, n);

            System.out.println();

            System.out.println("Intersection of two arrays is ");
            u_i.printIntersection(arr1, arr2, m, n);
        }
    }
