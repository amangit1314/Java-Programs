package searchingSortingProblems;

import java.util.Scanner;

public class SSP_Problem_02_1 {
    static int linearSearch(int[] a){
        int i = 0;
        if(a[i] == i)
            return i;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Fixed Point is " + linearSearch(a));
    }
}

// TIME COMPLEXITY => O(n)