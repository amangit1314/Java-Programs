package arrays.array;
import java.util.*;

// TITLE => Kadane's Algo [V.V.V.V.V IMP]
public class Problem13{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            n = sc.nextInt();

        int maxSum = 0;
        int currSum = 0;
        for(int i = 0; i <= n; i++){
            currSum += a[i];
            if(currSum < 0)
                currSum = 0;
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
    }
}