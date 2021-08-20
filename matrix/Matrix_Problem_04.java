package matrix;

// Problem Title => Find row with maximum no. of 1's
public class Matrix_Problem_04 {

    static int R = 4, C = 4;
    // Function that returns index of row with maximum number of 1s.
    static int rowWithMax1s(int[][] mat) {

        // Initialize first row as row with max 1s
        int j,max_row_index = 0;
        j = C - 1;

        for (int i = 0; i < R; i++) {
            // Move left until a 0 is found
            while (j >= 0 && mat[i][j] == 1) {
                j = j - 1; // Update the index of leftmost 1
                // seen so far
                max_row_index = i; // Update max_row_index
            }
        }

        if(max_row_index==0&&mat[0][C-1]==0)
            return -1;

        return max_row_index;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 }
        };
        System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat));
    }
}