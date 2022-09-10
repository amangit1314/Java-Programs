package arrays.array;

import java.util.Scanner;

// TITLE => Minimum no. of Jumps to reach end of an arrays.array
public class Problem10{

    static int minJumps(int[] a, int l, int h){
        if(h == 1)
            return 0;
        if(a[l] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + a[l]; i++) {
            int jumps = minJumps(a, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

    }
}