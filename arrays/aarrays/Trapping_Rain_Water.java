package arrays.aarrays;
// Problem Title -> Tapping Rain Water Problem
public class Trapping_Rain_Water {

    public static int maxWater(int[] a, int n){
        int res = 0;
        for(int i = 0; i < n-1; i++){
            int left = a[i];
            for (int j = 0; j < i; j++){
                left = Math.max(left, a[j]);
            }

            int right = a[i];
            for (int j = i+1; j < n; j++){
                right = Math.max(right, a[j]);
            }
            res += Math.min(left, right) - a[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}