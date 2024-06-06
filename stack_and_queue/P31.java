package stack_and_queue;

// Minimum Time required to rot all oranges

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col, time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class P31 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0, tm = 0, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] drow = { -1, 1, 0, 0 };
        int[] dcol = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;

            tm = Math.max(tm, t);

            q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = r + drow[i];
                int nCol = c + dcol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2;
                    count++;
                }
            }
        }
        if (count != fresh)
            return -1;

        return tm;
    }

    public static void main(String[] args) {

    }
}