package arrays;

/* Problem Title :-> Minimum swaps required bring elements less equal K together */
public class Array_Problem_34 {

    static int minSwap(int[] a, int n, int k){
        int count = 0;
        for (int i = 0; i < n; ++i){
            if (a[i] <= k)
                ++count;
        }

        int bad = 0;
        for (int i = 0; i < count; ++i){
            if (a[i] > k)
                ++bad;
        }
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j ){
            if(a[i] > k)
                --bad;
            if(a[j] > k)
                ++bad;
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 3};
        int n = a.length;
        int k = 3;
        System.out.print(minSwap(a, n, k) + "\n");

        int[] a1 = {2, 7, 9, 5, 8, 7, 4};
        n = a1.length;
        k = 5;
        System.out.print(minSwap(a1, n, k));
    }

}
