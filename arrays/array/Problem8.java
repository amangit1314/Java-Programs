package arrays.array;

import java.util.Scanner;

// TITLE => find Largest sum contiguous Sub-arrays.array [V. IMP]
public class Problem8{
    static int maxSumSubArray(int[] a){
        int maxSum = 0;
        int currSum = 0;
        for(int i = 1; i < a.length; i++){
            currSum = currSum + a[i];
            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(maxSumSubArray(a));
    }
}