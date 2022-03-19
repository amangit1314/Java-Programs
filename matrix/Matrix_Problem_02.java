package matrix;
// Problem Title => Search an element in a matrix
public class Matrix_Problem_02 {
    static int R = 4;
    static int C = 4;

    // Function for printing matrix in spiral
    // form i, j: Start index of matrix, row
    // and column respectively m, n: End index
    // of matrix row and column respectively
    static void print(int[][] arr, int i, int j, int m, int n)
    {
        // If i or j lies outside the matrix
        if (i >= m || j >= n) {
            return;
        }

        // Print First Row
        for (int p = i; p < n; p++) {
            System.out.print(arr[i][p] + " ");
        }

        // Print Last Column
        for (int p = i + 1; p < m; p++) {
            System.out.print(arr[p][n - 1] + " ");
        }

        // Print Last Row, if Last and
        // First Row are not same
        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                System.out.print(arr[m - 1][p] + " ");
            }
        }

        // Print First Column, if Last and
        // First Column are not same
        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                System.out.print(arr[p][j] + " ");
            }
        }
        print(arr, i + 1, j + 1, m - 1, n - 1);
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // Function Call
        print(a, 0, 0, R, C);
    }
}