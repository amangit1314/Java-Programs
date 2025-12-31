package dp;

/*
 * <------------------------------------------------------------------------------------------------------------------->
 * Problem Title :-  Largest rectangular sub-matrix whose sum is 0
*/


import java.io.*;
import java.util.*;

/**
* Given a 2D matrix of dimension n x m, the task is to find the area of largest submatrix whose sum is 0.
* Examples: 
    Input: mat[][] = [[9,  7, 16,  5], [1, -6, -7,  3], [1,  8,  7,  9], [7, -2,  0, 10]]
    Output: 6

* Explanation: Largest-SubMatrix-with-Sum-0
    Input: mat[][] = [[1,  2,  3], [-3, -2, -1], [1,  7,  5]]
    Output: 6

* Explanation: 
    Largest-SubMatrix-with-Sum-0-2
    Input: mat[][] = [[1, -1], [-1, 1]]
    Output: 4

* Explanation: The largest submatrix with sum 0 is [[1, -1], [-1, 1]].

* Table of Content
    [Naive Approach] Using four Nested Loops - O(n^4) Time and O(n^2) Space
    [Expected Approach] Using Prefix Sum - O(n^3) Time and O(n) Space
    [Naive Approach] Using four Nested Loops - O(n^4) Time and O(n^2) Space
        - The naive solution for this problem is to check the sum of every possible rectangle in given 2D array. For this we can use four nested loop to fix the upper row, bottom row, left column and right column of the sub matrix.
        - Now for each such sub matrix we can find its sum using a 2D prefix sum matrix in constant time. If this calculated sum is equal to 0 then update the maximum area found.

    * [Expected Approach] Using Prefix Sum - O(n^3) Time and O(n) Space
        - The idea is to iterate over all pairs of rows to fix the top and bottom row (or height) of the 0-sum submatrix. Let's see how to get the width of the largest submatrix with 0-sum.
        - To find the width of largest submatrix with zero sum for a given top and bottom row pair:

* For a given top-bottom pair, we compute the column-wise cumulative sum in a temporary array temp[].
    Now find the length of Longest Subarray with 0 Sum in temp[] array.
    The Length of longest Subarray with 0 Sum in temp[] array will also be the width of the largest 0-sum submatrix.
 */

public class DP_Problem_55 {
  
    // Function to find the largest zero-sum subarray
    static int maxZeroSumSubarray(int[] arr) {
        int prefSum = 0;
        int maxLength = 0;

        // Hash map to store the first index of each prefix sum
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Iterate through the array to find subarrays with zero sum
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];

            if (prefSum == 0) 
                maxLength = i + 1;

            if (mp.containsKey(prefSum)) {
                // If this prefSum repeats, find subarray length.
                maxLength = Math.max(maxLength, (i - mp.get(prefSum)));
            } else {
                // Only store the index of the first occurrence of prefSum
                mp.put(prefSum, i);
            }
        }

        return maxLength;
    }

    static int zeroSumSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Temporary array to store the column-wise cumulative sum
            int[] temp = new int[cols];

            // Iterate over each row from i to j
            for (int j = i; j < rows; j++) {

                // Accumulate the column-wise sum for rows between i and j
                for (int k = 0; k < cols; k++)
                    temp[k] += mat[j][k];

                // Find the longest zero-sum subarray in column sums
                int len = maxZeroSumSubarray(temp);

                // Update the maximum area 
                maxArea = Math.max(maxArea, (j - i + 1) * len);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {9, 7, 16, 5}, 
            {1, -6, -7, 3}, 
            {1, 8, 7, 9}, 
            {7, -2, 0, 10}
        };
        System.out.println(zeroSumSubmat(mat));
    }
}