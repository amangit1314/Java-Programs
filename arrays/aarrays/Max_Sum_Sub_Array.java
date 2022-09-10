package arrays.aarrays;
// The Kadens Algorithm
public class Max_Sum_Sub_Array {

    static int maxSubArraySum(int[] a){
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i = 0; i < n; i++){
            curr = curr + a[i];
            if(curr > max)
                max = curr;
            if(curr < 0)
                curr = 0;
        }

        if(curr == 0)
            return 0;

        return max;
    }
    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }
}