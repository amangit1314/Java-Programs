package greedy;

// Max sum of absolute differences of an array

public class Problem_18 {
    static int maxSumOfArrI(int[] arr, int n) {
        java.util.Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, -1, 4};
        int n = arr.length;

        int result = maxSumOfArrI(arr, n);
        System.out.println("Maximum sum of arr[i]*i: " + result);
    }
}
