package greedy;

// Check if it is possible to survive on island

public class Problem_13 {
    static boolean canSurvive(int[] arr, int n, int k) {
        java.util.Arrays.sort(arr);
        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                maxDays++;
                k -= arr[i];
            } else {
                break;
            }
        }

        return maxDays == n;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int k = 10;

        if (canSurvive(arr, n, k)) {
            System.out.println("Yes, it is possible to survive on the island.");
        } else {
            System.out.println("No, it is not possible to survive on the island.");
        }
    } 
}