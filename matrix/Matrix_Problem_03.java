package matrix;
import java.util.*;
/*
 * Title: Find median in a row wise sorted matrix
 * We are given a row-wise row-wise matrix of size r*c, we need to find the median of matrix given.
 * It is assumed that r*c is always odd.
 */
/*
 * Examples:
 * Input:
 * 2 6 9
 * 3 6 9
 * 
 * Output: Median is 5
 * 
 * If we put all the values in a sorted array A[] = (1 2 3 3 5 6 6 9 9)
 * Input: 1 3 4
 * 		  2 5 6
 * 		  7 8 9
 * Output: Median is 5
 */
/*
 * Simple Method:
 * The simplest method to solve this problem is to store all the elements of the given matrix in an array of size r*c.
 * Then we can either sort the array and find the median element in O(r*clog(r*c))
 * or 
 * we can use the approach discussed to find the median in O(r*c).
 * Auxiliary space required will be O(r*c) in both the cases.
 * An efficient approach for this problem is to use a binary search algorithm.
 * The idea is that for a number of median there should be exactly (n/2) numbers which are less than all the numbers.
 * Below is the step by step algorithm for this approach:
 */
/*  ALGORITHM:
 * 
 *  1.	First, we find the minimum and maximum element in the matrix.
 *  	The minimum element can be easily found by comparing the first element of each row,
 *  	 and similarly , the maximum element can be found by comparing the last element of each row.
 *  
 *  2.	Then we use binary search on our range of numbers from minimum to maximum,
 *  	we find the mid of the min and max and get a count of numbers less then our mid.
 *  	And accordingly change the min or max.
 *  
 *  3.  For a number to be median, there should be (r*c)/2 numbers smaller than that number.
 *  	So for every number, we get the count of numbers less than that by using upper_bound() in each row of th ematrix,
 *  	if it is less than the required count, the median must be greater than the selected number, 
 *  	else the median must be less then or equal to the selected number
 *   
 */
public class Matrix_Problem_03 {

    // function to find the median in matrix
    static int binaryMedian(int m[][], int r, int c) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            // finding the minimum element
            if (m[i][0] < min)
                min = m[i][0];
            // finding the maximum element
            if (m[i][c - 1] > max)
                max = m[i][c - 1];
        }

        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            // find count of elements smaller than mid
            for (int i = 0; i < r; ++i) {
                get = Arrays.binarySearch(m[i], mid);
                /*
                 *  if element is not found in the array the binarySearch() method returns
                 *  searched element by the following calculation
                 */   
                if (get < 0)
                    get = Math.abs(get) - 1;
                /*
                 * If the element is found in the array it returns the index(any index in case
                 * of duplicate).
                 * 
                 * So we go to last index of element, which will give the number of elements
                 * smaller than the number including the searched element.
                 */
                else {
                    while (get < m[i].length && m[i][get] == mid)
                        get += 1;
                }
                place = place + get;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    // Driver program to test above method
    public static void main(String[] args) {
        int r = 3, c = 3;
        int m[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        System.out.println("Median is" + binaryMedian(m, r, c));
    }

}

