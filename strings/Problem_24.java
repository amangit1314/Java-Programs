package strings;

//* Search a Word in a 2D Grid of characters.
public class Problem_24 {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true; // Word found starting from this cell
                }
            }
        }

        return false; // Word not found in the grid
    }

    private static boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true; // Entire word found
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Mark the current cell as visited to avoid revisiting
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, row - 1, col, word, index + 1) // Up
                || dfs(board, row + 1, col, word, index + 1) // Down
                || dfs(board, row, col - 1, word, index + 1) // Left
                || dfs(board, row, col + 1, word, index + 1); // Right

        // Backtrack: reset the cell value after exploration
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";

        if (exist(board, word)) {
            System.out.println("Word '" + word + "' found in the grid.");
        } else {
            System.out.println("Word '" + word + "' not found in the grid.");
        }
    }
}
