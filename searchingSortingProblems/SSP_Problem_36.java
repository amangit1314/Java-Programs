package searchingSortingProblems;

// Partitioning and Sorting Arrays with Many Repeated Entries
public class SSP_Problem_36 {
    public static void partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose the first element as the pivot
        int i = low + 1;
        int j = high;

        while (i <= j) {
            if (arr[i] < pivot) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, j);
                j--;
            } else {
                i++; // Element equal to pivot, keep it in the middle section
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 5, 6, 4 };
        int n = arr.length;

        partition(arr, 0, n - 1);

        System.out.println("Partitioned array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
