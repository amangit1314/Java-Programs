package arrays.aarrays;

import java.util.Arrays;
import java.util.Scanner;

public class Cyclically_rotate_by_one {
    static void rotate(int[] arr, int n){
        int x = arr[n-1];
        System.arraycopy(arr, 0, arr, 1, n - 1);
        arr[0] = x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Given Array is");
        System.out.println(Arrays.toString(a));

        rotate(a, a.length);

        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(a));
    }
}