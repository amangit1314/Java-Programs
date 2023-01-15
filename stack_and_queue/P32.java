package stack_and_queue;

// Distance of the nearest cell having 1 in a binary matrix

public class P32 {
    //Function to find distance of nearest 1 in the grid for each cell.
    static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[][] nearest(int[][] grid) {
        // Code here
        int n, m;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        int x, y, count;
        for (int k = 0; k < n * m; ++k) {
            count = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == k) {
                        for (int[] direction : directions) {
                            x = i + direction[0];
                            y = j + direction[1];

                            if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != -1) {
                                continue;
                            }
                            grid[x][y] = k + 1;
                            ++count;
                        }
                    }
                }
            }
            if (count == 0) {
                break;
            }
        }
        return grid;
    }

    public static void main(String[] args) {

    }
}