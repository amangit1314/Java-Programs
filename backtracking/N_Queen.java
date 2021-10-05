package backtracking;

public class N_Queen {
    final int N = 4;

    void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
                System.out.println();
            }
        }
    }

    boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    boolean solveNQUtil(int[][] board, int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                //If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col]
                board[i][col] = 0;  //"BACKTRACK"
            }
        }

        // If the queen can not be placed in any row in this col, then return false
        return false;
    }
    
    /*
    * This function solves the N-Queen problem using "BACKTRACKING".
    * It mainly uses solveNQUtil() to solve the problem.
    * It returns false if queens cannot place, otherwise,
    * return true & prints placement of queens in the form of 1's.  
    * Please note that there may be more than one solution,
    * this function prints one of the feasible solutions.
    */
    void solveNQ() {
        int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    //Driver program to test above functions
    public static void main(String[] args) {
        N_Queen nq = new N_Queen();
        nq.solveNQ();
    }
}
