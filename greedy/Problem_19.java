package greedy;

// Max sum of consecutive differences in a circular array

public class Problem_19 {
    static int maxSumOfAbsDiff(int[] arr, int n) {
        java.util.Arrays.sort(arr);
        int sum = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            sum += 2 * (arr[right] - arr[left]);
            left++;
            right--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, -1, 4};
        int n = arr.length;

        int result = maxSumOfAbsDiff(arr, n);
        System.out.println("Maximum sum of absolute differences in circular array: " + result);
    }
}
