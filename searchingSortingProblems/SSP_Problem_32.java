package searchingSortingProblems;
//* Double Helix SPOJ
public class SSP_Problem_32 {

    public static int findMaxSum(int[] arr1, int[] arr2, int m, int n) {
        int sum1 = 0;
        int sum2 = 0;
        int i = 0, j = 0;

        // Iterate through both arrays until one of them is exhausted
        while (i < m && j < n) {
            // Compare elements and update sums and indices accordingly
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j++];
            } else {
                // If elements are equal, add them to both sums and increment both indices
                sum1 += arr1[i];
                sum2 += arr2[j];
                i++;
                j++;
            }
        }

        // Add remaining elements from the non-exhausted array to its respective sum
        while (i < m) {
            sum1 += arr1[i++];
        }
        while (j < n) {
            sum2 += arr2[j++];
        }

        // Return the maximum sum
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 5, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };

        int maxSum = findMaxSum(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Maximum sum along the double helix: " + maxSum);
    }
}
