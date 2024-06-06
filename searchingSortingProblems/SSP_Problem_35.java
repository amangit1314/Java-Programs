package searchingSortingProblems;
// merge sort in place

class SSP_Problem_35 {
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2; // Avoid overflow for large arrays
            mergeSort(arr, low, mid); // Sort left half
            mergeSort(arr, mid + 1, high); // Sort right half
            merge(arr, low, mid, high); // Merge the sorted halves
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1; // Size of left subarray
        int n2 = high - mid; // Size of right subarray

        // Create temporary arrays to hold left and right subarrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        // Merge the temporary arrays back into arr[low..high]
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
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
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 3, 1, 8, 7 };
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}