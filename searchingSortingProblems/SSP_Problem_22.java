package searchingSortingProblems;

// find pivot
public class SSP_Problem_22 {

    public static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Handle cases where the array is not rotated or has only one element
        if (arr[low] <= arr[high]) {
            return -1; // Not rotated or only one element (no pivot)
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the middle element is the pivot
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid; // Pivot found
            }

            // If the left half is sorted (arr[mid] <= arr[high]), search in the right half
            if (arr[mid] <= arr[high]) {
                low = mid + 1;
            } else { // Right half must be sorted, search in the left half
                high = mid;
            }
        }

        return -1; // Pivot not found (should not happen)
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 6, 1, 2, 3 };
        int[] arr2 = { 1 }; // Not rotated

        int pivot1 = findPivot(arr1);
        int pivot2 = findPivot(arr2);

        System.out.println("Pivot element in arr1: " + pivot1);
        System.out.println("Pivot element in arr2: " + pivot2); // -1 (not rotated)
    }
}
