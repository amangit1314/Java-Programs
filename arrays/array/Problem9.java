package arrays.array;

import java.util.Arrays;
import java.util.Scanner;

// TITLE => Minimise the maximum difference between heights [V.IMP]
public class Problem9{

    // Modifies the arrays.array by subtracting/adding k to every element
    // such that the difference between maximum and minimum is minimized
    static int getMinDiff(int[] a, int n, int k){
        if(n == 1)
            return 0;

        // Sort all elements
        Arrays.sort(a);

        // Initialize result
        int ans = a[n-1] - a[0];

        // Handle corner elements
        int small = a[0] + k;
        int big = a[n-1] - k;
        int temp;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < n-1; i ++) {
            int subtract = a[i] - k;
            int add = a[i] + k;

            // If both subtraction and addition
            // do not change diff
            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller number or addition causes a greater number.
            // Update small or big using greedy approach (If big - subtract causes smaller difference ,
            // update small Else update big)
            if (big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }

        return Math.min(ans, big - small);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 10;
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Maximum difference is " + getMinDiff(a, n, k));
    }
}