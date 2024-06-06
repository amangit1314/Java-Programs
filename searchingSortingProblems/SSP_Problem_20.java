package searchingSortingProblems;

public class SSP_Problem_20 {
    public static int findBCSSize(int[][] A, int[][] B) {
        int n = A.length; // Number of rows in A (and B)
        int m = A[0].length; // Number of columns in A (and B)

        int maxSide = Math.min(n, m); // Maximum possible side length of BCS

        // Binary search for the size of the BCS
        for (int side = maxSide; side >= 1; side--) {
            if (isSubsquarePresent(A, B, side, n, m)) {
                return side;
            }
        }

        return 0; // No BCS found
    }

    private static boolean isSubsquarePresent(int[][] A, int[][] B, int side, int n, int m) {
        for (int i = 0; i <= n - side; i++) {
            for (int j = 0; j <= m - side; j++) {
                if (isSubsquareMatch(A, B, i, j, side)) {
                    return true; // BCS found
                }
            }
        }

        return false; // No BCS found in the current search area
    }

    private static boolean isSubsquareMatch(int[][] A, int[][] B, int rowA, int colA, int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (A[rowA + i][colA + j] != B[i][j]) {
                    return false; // Mismatch found, not a BCS
                }
            }
        }

        return true; // All elements match, it's a BCS
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 } };
        int[][] B = { { 1, 2 }, { 3, 4 } };

        int bcsSize = findBCSSize(A, B);
        System.out.println("Size of Biggest Common Subsquare: " + bcsSize);
    }
}
