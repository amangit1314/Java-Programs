package greedy;

// max product subset of an array

public class Problem_15{
    static int maxProductSubset(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int maxProduct = 1;
        int negativeCount = 0;
        int negativeMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negativeCount++;
                if (arr[i] > negativeMax) {
                    negativeMax = arr[i];
                }
            }
            maxProduct *= arr[i];
        }

        if (negativeCount % 2 == 1 && negativeCount > 1) {
            maxProduct /= negativeMax;
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, -1, 4};
        int n = arr.length;

        int result = maxProductSubset(arr, n);
        System.out.println("Maximum product of subset: " + result);
    }
}