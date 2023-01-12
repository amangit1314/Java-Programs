package arrays.interviewProblems;
// Problem - Merge two sorted arrays in O(1) time.
public class MergeTwoSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i < 0 || nums1[i] < nums2[j])
                nums1[k--] = nums2[j--];

            nums1[k--] = nums1[i--];
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 7, 8, 9};
        int[] nums2 = {2, 4, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);
        printArray(nums1, nums1.length + nums2.length);
    }
}