package backtracking;
import java.util.*;

/**
 * Given - Two positive integers N and M
 * Task - You have to find the Nth root of m such that M^(1/N)
 * Note - Nth root of an integer M is a real number which when raised to the power N gives M as result
 *        Nth root of M should be correct up tp 6 decimal place.
 * Example -
 *      i/p - 1
 *            3 27
 *      explanation - 3rd Root of 27 is 3.000000, as (3.000000)^3 is equal to 27
 * */


public class Nth_Root_of_M {

    public static double multiply(double number, int m) {
        double ans = 1.0;
        for(int i = 1; i <= m; i++)
            ans = ans * number;
        return ans;
    }

    public static double getNthRoot(int n, int m) {
        double low = 1;
        double hi = m;
        double ops = 1e-9;

        while((hi - low) > ops) {
            double mid = (low + hi) / 2 ;
            if(multiply(mid, n) < m)
                low = mid;
            else
                hi = mid;
        }
        return hi; // doubt hai is line m
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.print(getNthRoot(n, m));
    }
}