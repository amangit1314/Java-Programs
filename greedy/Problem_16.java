package greedy;

// max array sum after k negations

public class Problem_16{
    static int maxArraySumAfterKNegations(int[] arr, int n, int k) {
        java.util.Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (k > 0 && arr[i] < 0) {
                sum += -arr[i];
                k--;
            } else {
                sum += arr[i];
            }
        }
        if (k % 2 == 1) {
            sum -= 2 * arr[n - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, -1, 4};
        int n = arr.length;
        int k = 2;

        int result = maxArraySumAfterKNegations(arr, n, k);
        System.out.println("Maximum array sum after " + k + " negations: " + result);
    }
}