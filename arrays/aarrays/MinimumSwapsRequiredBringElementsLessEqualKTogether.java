package arrays.aarrays;

public class MinimumSwapsRequiredBringElementsLessEqualKTogether {
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

    }
}