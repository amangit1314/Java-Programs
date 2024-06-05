package arrays;

/*
 * find Largest sum contiguous Sub-arrays.array
 */

// public class Array_Problem_8 {

// 	 public static void main (String[] args)
// 	    {
// 	        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
// 	        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
// 	    }

// 	    static int maxSubArraySum(int a[])
// 	    {
// 	        int size = a.length;
// 	        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

// 	        for (int i = 0; i < size; i++)
// 	        {
// 	            max_ending_here = max_ending_here + a[i];
// 	            if (max_so_far < max_ending_here)
// 	                	max_so_far = max_ending_here;

// 	            if (max_ending_here < 0)
// 	                	max_ending_here = 0;
// 	        }
// 	        return max_so_far;
// 	    }

// }

public class Array_Problem_8 {

    public static void main(String[] args) {
        int[] inputArray = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maximumContiguousSum = findMaximumContiguousSubarraySum(inputArray);
        System.out.println("Maximum contiguous sum is: " + maximumContiguousSum);
    }

    static int findMaximumContiguousSubarraySum(int[] inputArray) {
        int arrayLength = inputArray.length;
        int currentMaximumSum = Integer.MIN_VALUE;  // Tracks the maximum sum found so far
        int currentSubarraySum = 0;               // Tracks the sum of the current subarray

        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            currentSubarraySum += inputArray[currentIndex];

            if (currentMaximumSum < currentSubarraySum) {
                currentMaximumSum = currentSubarraySum;
            }

            if (currentSubarraySum < 0) {  // Start a new subarray if the sum becomes negative
                currentSubarraySum = 0;
            }
        }

        return currentMaximumSum;
    }
}
