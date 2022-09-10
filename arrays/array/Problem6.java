package arrays.array;

// TITLE => Find Union and Intersection of Two sorted arrays.

import java.util.Arrays;

class Problem6{
    // Function to printUnion
    static void printUnion(int[] a1, int[] a2, int m, int n){
        if(m > n){
            int[] temp1 = a1;
            a1 = a2;
            a2 = temp1;

            int temp2 = m;
            m = n;
            n = temp2;
        }
        Arrays.sort(a1);
        for (int i = 0; i < m; i++)
            System.out.print(a1[i] + " ");

        // Search every element of bigger arrays.array in smaller arrays.array
        // and print the element IF not found
        for (int i = 0; i < n; i++) {
            if (binarySearch(a1, 0, m - 1, a2[i]) == -1)
                System.out.print(a2[i] + " ");
        }
    }

    // Function to printIntersection
    static  void printIntersection(int[] a1, int[] a2, int m, int n) {
        if(m > n){
            int[] temp1 = a1;
            a1 = a2;
            a2 = temp1;

            int temp2 = m;
            m = n;
            n = temp2;
        }
        Arrays.sort(a1);

        // Search every element of bigger arrays.array in smaller
        // arrays.array and print the element if found
        for (int i = 0; i < n; i++) {
            if (binarySearch(a1, 0, m - 1, a2[i]) != -1)
                System.out.print(a2[i] + " ");
        }
    }

    // Function to binary Search
    static int binarySearch(int[] a, int l, int r, int x){
        if(r >= l){
            int mid = l + (r - 1) /2;
            if(a[mid] == x)
                return mid;
            if(a[mid] > x)
                return binarySearch(a,mid - 1, r, x);

            return binarySearch(a,mid + 1, r, x);
        }
        return -1;
    }

    // DRIVER CODE
    public static void main(String[] args) {

        int[] a1 = { 1, 3, 5, 6, 79 };
        int[] a2 = { 3, 6, 7, 8, 20 };

        int m = a1.length;
        int n = a2.length;

        // Function call
        System.out.println("Union of two arrays is ");
        printUnion(a1, a2, m, n);

        System.out.println();

        System.out.println("Intersection of two arrays is ");
        printIntersection(a1, a2, m, n);
    }
}