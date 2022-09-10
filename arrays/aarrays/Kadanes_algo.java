package arrays.aarrays;

public class Kadanes_algo {

    public static int kadanes(int[] a, int n){
        int max = Integer.MIN_VALUE;
        int cr = 0;
        for (int i = 0; i < n; i++){
            cr = cr + a[i];
            if(cr > max)
                max = cr;
            if(cr < 0)
                cr = 0;
        }
        if(cr == 0)
            return 0;
        return max;
    }

    public static void main(String[] args) {
        int[] a = {23, 45, 2, 5, 9, 8, 6};
        int n = a.length;
        System.out.println("Maximum sum is -> " + kadanes(a, n));
    }
}