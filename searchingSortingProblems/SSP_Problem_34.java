package searchingSortingProblems;

public class SSP_Problem_34 {
    public static int mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            int leftCount = mergeSort(arr, low, mid); // Sort left half and count inversions
            int rightCount = mergeSort(arr, mid + 1, high); // Sort right half and count inversions
            int mergeCount = merge(arr, low, mid, high); // Merge sorted halves and count inversions
            return leftCount + rightCount + mergeCount;
        }
        return 0; // Base case: single element array has 0 inversions
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1; // Size of left subarray
        int n2 = high - mid; // Size of right subarray

        // Create temporary arrays to hold left and right subarrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        // Merge the temporary arrays back into arr[low..high]
        int i = 0, j = 0, k = low, inversionCount = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                // Inversion occurs if left element is greater than right element
                inversionCount += n1 - i;
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements (if any)
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 1, 8, 7 };
        int n = arr.length;

        int inversionCount = mergeSort(arr, 0, n - 1);

        System.out.println("Array after sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nInversion Count: " + inversionCount);
    }
}
