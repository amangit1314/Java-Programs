package greedy;

// Smallest subset with sum greater than all other elements

public class Problem_23 {
    static int smallestSubset(int[] arr, int n) {
        java.util.Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int subsetSum = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            subsetSum += arr[i];
            count++;
            if (subsetSum > sum - subsetSum) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        int n = arr.length;

        int result = smallestSubset(arr, n);
        System.out.println("Smallest subset with sum greater than all other elements: " + result);
    }
}
     