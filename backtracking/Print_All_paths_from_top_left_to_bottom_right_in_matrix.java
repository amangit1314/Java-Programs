package backtracking;

import java.util.*;

/**
 * Given - m * n matrix.
 * Task - print all the possible paths from top left to bottom right of m*n matrix.
 * Example -
 *      i/p - 1 2 3
 *            4 5 6
 *
 *      o/p -  1 4 5 6
 *             1 2 5 6
 *             1 2 3 6
 */

public class Print_All_paths_from_top_left_to_bottom_right_in_matrix {

    public static void display(ArrayList<Integer> ans) {
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isSafe(int r, int c, int[][] visited, int n, int m) {
        return (r < n && c < m && visited[r][c] != -1);
    }

    public static void findPaths(int[][] grid, int r, int c, int n, int m,ArrayList<Integer> ans ) {
        if(r == n -1 && c == m -1) {
            ans.add(grid[r][c]);
            display(ans);
            ans.remove(ans.size() - 1);
            return;
        }

        int ch = grid[r][c];
        ans.add(ch);
        grid[r][c] = -1;

        if(isSafe(r +1, c, grid, n, m)) {
            findPaths(grid, r + 1, c, n, m, ans);
        }

        if(isSafe(r, c + 1, grid, n, m)) {
            findPaths(grid, r, c + 1, n, m, ans);
        }

        grid[r][c] = ch;

        ans.remove(ans.size() - 1);
        return;
    }

    public static void main(String[] args) {

    }
}