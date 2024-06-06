package searchingSortingProblems;

public class SSP_Problem_23 {
    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        int m = arr1.length;
        int n = arr2.length;

        // Handle edge cases
        if (k <= 0 || k > m + n) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        int low = Math.max(0, k - n); // Minimum possible index in arr1
        int high = Math.min(k, m); // Maximum possible index in arr1 (inclusive)

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            // Handle edge cases for empty halves
            int leftElement1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int rightElement1 = mid1 == m ? Integer.MAX_VALUE : arr1[mid1];
            int leftElement2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int rightElement2 = mid2 == n ? Integer.MAX_VALUE : arr2[mid2];

            // Check if the mid elements from both arrays are in the correct position for
            // Kth element
            if (leftElement1 <= rightElement2 && rightElement1 >= leftElement2) {
                return rightElement1 > rightElement2 ? rightElement2 : rightElement1;
            } else if (leftElement1 > rightElement2) {
                high = mid1 - 1; // Move search to the left half of arr1
            } else {
                low = mid1 + 1; // Move search to the right half of arr1
            }
        }

        return -1; // Kth element not found (should not happen with valid input)
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 5;

        int kthElement = findKthElement(arr1, arr2, k);
        System.out.println("Kth element (" + k + "): " + kthElement);
    }
}
