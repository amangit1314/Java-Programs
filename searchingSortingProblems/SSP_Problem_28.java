package searchingSortingProblems;

public class SSP_Problem_28 {
    public static int findMissingNumberFormula(int[] arr, int n) {
        int firstTerm = arr[0];
        int lastTerm = arr[n - 1];
        int commonDiff = (lastTerm - firstTerm) / (n - 1);

        for (int i = 1; i < n; i++) {
            int expectedTerm = firstTerm + (i - 1) * commonDiff;
            if (arr[i] != expectedTerm) {
                return expectedTerm;
            }
        }

        return -1; // No missing number found
    }

    public static int findMissingNumberDifference(int[] arr, int n) {
        int diff = arr[1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return arr[i - 1] + diff;
            }
        }

        return -1; // No missing number found
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 10 }; // Missing number at position 3
        int[] arr2 = { 3, 5, 9 }; // Missing number between 5 and 9

        int missing1 = findMissingNumberFormula(arr1, arr1.length);
        int missing2 = findMissingNumberDifference(arr2, arr2.length);

        System.out.println("Missing number using formula (arr1): " + missing1);
        System.out.println("Missing number using difference (arr2): " + missing2);
    }
}
