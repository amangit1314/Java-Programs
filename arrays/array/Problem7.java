package arrays.array;

import java.util.Arrays;
import java.util.Scanner;

class Problem7{
    static void rotate(int[] a){
        int x = a[a.length-1], i;
        for (i = a.length-1; i > 0; i--)
            a[i] = a[i-1];
        a[0] = x;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Given Array is");
        System.out.println(Arrays.toString(a));

        rotate(a);

        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(a));
    }
}