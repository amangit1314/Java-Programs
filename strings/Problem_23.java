package strings;

// ** Count of number of given string in 2D character array
public class Problem_23 {
    public static int countOccurrences(char[][] grid, String str) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == str.charAt(0) && isValidMatch(grid, i, j, str, 0)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValidMatch(char[][] grid, int row, int col, String str, int index) {
        if (index == str.length()) {
            return true; // Entire string matched
        }

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != str.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Check all eight directions recursively
        return isValidMatch(grid, row - 1, col, str, index + 1) // Up
                || isValidMatch(grid, row + 1, col, str, index + 1) // Down
                || isValidMatch(grid, row, col - 1, str, index + 1) // Left
                || isValidMatch(grid, row, col + 1, str, index + 1) // Right
                || isValidMatch(grid, row - 1, col - 1, str, index + 1) // Up-Left diagonal
                || isValidMatch(grid, row - 1, col + 1, str, index + 1) // Up-Right diagonal
                || isValidMatch(grid, row + 1, col - 1, str, index + 1) // Down-Left diagonal
                || isValidMatch(grid, row + 1, col + 1, str, index + 1); // Down-Right diagonal
    }

    public static void main(String[] args) {
        char[][] grid = {
                { 'F', 'A', 'C', 'E' },
                { 'S', 'E', 'A', 'R' },
                { 'C', 'H', 'T', 'S' },
                { 'A', 'I', 'D', 'E' }
        };
        String str = "SEARCH";

        int count = countOccurrences(grid, str);
        System.out.println("Total occurrences of '" + str + "' in the grid: " + count);
    }
}
