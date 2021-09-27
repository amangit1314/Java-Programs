package miscellaneous;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {

    int count = 0;

    public static int getRandomValue(int Min, int Max) {
        // Get and return the random integer within Min and Max
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }

    public static int search(int[] a, int n, int l, int r, int e){
        l = 0;
        r = n;

        if(r >= l){
            int m = l + (r-l)/2;

            if(a[m] == e)
                return m;

            if(a[m] > e)
                search(a, n, l, m-1, e);

            search(a, n, l, m+1, e);
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int l = 0, r = n, e;

        System.out.println("Enter the value to be found");
        e = sc.nextInt();

        System.out.println("Enter Min and Max range of random values");
        int Min = sc.nextInt(), Max = sc.nextInt();

        System.out.println("Input elements of array");
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = getRandomValue(Min, Max);
            System.out.println(a[i] + " ");
        }
        search(a, n, l, r, e);
    }
}