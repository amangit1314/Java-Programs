package arrays.aarrays;
import java.util.Arrays;

public class Minimum_Max_Difference_btwn_heights {

    static int getMinDiff(int[] a, int n, int k){
        if(n == 1)
            return 0;

        Arrays.sort(a);

        int ans = a[n-1]-a[0];
        int small = a[0]+k;
        int big = a[n-1]-k;
        int temp = 0;

        if(small > big){
            temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n-1; i ++) {
            int subtract = a[i] - k;
            int add = a[i] + k;

            if (subtract >= small || add <= big)
                continue;

            if (big - subtract <= add - small)
                small = subtract;

            else
                big = add;
        }

        return Math.min(ans, big - small);
    }

    public static void main(String[] args) {
        int[] a = {23, 45, 9, 2, 6, 90, -1};
        int n = a.length;
        int k = 9;
        System.out.println("Maximum difference is " + getMinDiff(a, n, k));
    }
}