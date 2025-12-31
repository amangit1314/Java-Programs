package dp;
// Problem: Count all subsequences having product less than K

public class DP_Problem_20 {

    // Function to count all subsequences with product less than K
    public static int countSubseqProductLessThanK(int[] arr, int K) {
        return countHelper(arr, 0, 1, K);
    }

    // Recursive helper function
    private static int countHelper(int[] arr, int index, long prod, int K) {
        if (index == arr.length) {
            // If the current product is less than K and we have chosen at least one element
            return prod < K && prod > 1 ? 1 : 0;
        }

        // Include current element
        long newProd = prod * arr[index];
        int include = 0;
        if (newProd < K) {
            include = countHelper(arr, index + 1, newProd, K);
        }

        // Exclude current element
        int exclude = countHelper(arr, index + 1, prod, K);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 101, 2, 3, 100, 4, 5 };

        int maxSum = maxSumIS(arr);
        System.out.println("Maximum sum of increasing subsequence: " + maxSum);
    }
}
