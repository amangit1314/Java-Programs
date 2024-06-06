package matrix;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] zr = new int[n];
        int[] zc = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zr[i] = 1;
                    zc[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (zr[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            if (zc[j] == 1) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
