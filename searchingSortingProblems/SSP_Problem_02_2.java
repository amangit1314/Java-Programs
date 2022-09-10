package searchingSortingProblems;

import java.util.Scanner;

// Problem Title => Find a Fixed Point (Value equal to index) in a given arrays.array
public class SSP_Problem_02_2 {
    static int binarySearch(int[] a, int start, int end){
        if(end >= start){
            int mid = (start+end)/2;
            if(mid == a[mid])
                return mid;
            if(mid >= a[mid])
                return binarySearch(a, mid+1, end);
            else
                return binarySearch(a, start, mid-1);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Fixed Point is " + binarySearch(a,0, n-1));
    }
}

