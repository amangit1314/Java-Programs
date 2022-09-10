package searchingSortingProblems;

import java.util.Scanner;

// Problem Title => square root of an integer
public class SSP_Problem_04_1 {

    static int floorSqrt(int x){
        // base case
        if(x == 0 || x == 1)
            return x;

        // maintaining counter's
        int i = 1, result = 1;
        while(result <= x){
            i++;
            result = i*i;
        }
        return i-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.print(floorSqrt(x));
    }
}

// Time Complexity => O(^n) [It means root n].
// Space Complexity => O(1) [Constant].