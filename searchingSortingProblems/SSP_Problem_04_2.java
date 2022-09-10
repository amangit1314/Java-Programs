package searchingSortingProblems;

import java.util.Scanner;

// Problem Title => square root of an integer
public class SSP_Problem_04_2 {

    static int floorSqrt(int x){
        // base case
        if(x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x, ans = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            // checking if that is the square root of middle number
            if(mid*mid == x)
                return (int)mid;

            // checking if that is smaller than the square root of middle number
            if(mid*mid < x){
                start = mid+1;
                ans = mid;
            }

            else
                end = mid-1;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.print(floorSqrt(x));
    }
}

// Time Complexity => O(log n) [It means Log n Time will be taken].
// Space Complexity => O(1) [Constant Time will be taken].
