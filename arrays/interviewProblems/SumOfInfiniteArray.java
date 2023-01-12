package arrays.interviewProblems;
import java.util.*;

public class SumOfInfiniteArray {
    static int mod = (int) 1e9+7;

    public static long sumOfArray(int[] sumArray, long x, int n){
        long factor = (x / n) % mod;
        long sum =  (factor * sumArray[n]) % mod;
        sum = (sum + sumArray[(int)(x % n)]) % mod;
        return sum;
    }

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        // Write your code here!

        List<Integer> list_of_sum = new LinkedList<>();
        int x = 0, sum;
        long l, r, lsum, rsum;
        int[] sumArr = new int[n+1];
        for(int i = 1; i <= n; i++){
            sumArr[i] = (sumArr[i - 1] + arr[i - 1]) % mod;
        }

        while(q-- > 0){
            l = queries.get(x).get(0);
            r = queries.get(x).get(1);
            lsum = sumOfArray(sumArr, l-1, n);
            rsum = sumOfArray(sumArr, r, n);
            sum = (int)(rsum - lsum + mod)%mod;
            list_of_sum.add(sum);
            x++;
        }

        return list_of_sum;
    }

    public static void main(String[] args) {

    }
}