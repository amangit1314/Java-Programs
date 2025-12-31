package greedy;

// Min sum of absolute differences of pairs of two arrays

public class Problem_20 {
    static int minSumOfAbsDiff(int[] arr1, int[] arr2, int n) {
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 7};
        int[] arr2 = {2, 3, 6, 5};
        int n = arr1.length;

        int result = minSumOfAbsDiff(arr1, arr2, n);
        System.out.println("Minimum sum of absolute differences of pairs: " + result);
    }
}
