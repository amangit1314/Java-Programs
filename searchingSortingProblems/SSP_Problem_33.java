package searchingSortingProblems;

// Subset Sums
public class SSP_Problem_33 {
    public static boolean hasSubsetSum(int[] arr, int n, int sum) {
        if (sum == 0) { // Empty subset with sum 0 always exists
            return true;
        }
        if (n == 0 || sum < 0) { // No elements left or negative sum, no subset possible
            return false;
        }

        // Try including the current element or excluding it
        return hasSubsetSum(arr, n - 1, sum) || // Exclude current element
                hasSubsetSum(arr, n - 1, sum - arr[n - 1]); // Include current element
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 7, 1 };
        int sum = 6;

        if (hasSubsetSum(arr, arr.length, sum)) {
            System.out.println("Subset with sum " + sum + " exists");
        } else {
            System.out.println("No subset with sum " + sum + " exists");
        }
    }
}
