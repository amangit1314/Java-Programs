package matrix;

class Word_Search {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length())
            return false;

        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ++boardf[board[i][j]];
            }
        }

        for (char ch : wrd) {
            if (--boardf[ch] < 0) {
                return false;
            }
        }

        if (boardf[wrd[0]] > boardf[wrd[wrd.length - 1]])
            reverse(wrd);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (wrd[0] == board[i][j]
                        && found(board, i, j, wrd, new boolean[m][n], 0))
                    return true;
            }
        }
        return false;
    }

    private void reverse(char[] word) {
        int n = word.length;
        for (int i = 0; i < n / 2; ++i) {
            char temp = word[i];
            word[i] = word[n - i - 1];
            word[n - i - 1] = temp;
        }
    }

    private static final int[] dirs = { 0, -1, 0, 1, 0 };

    private boolean found(char[][] board, int row, int col, char[] word,
            boolean[][] visited, int index) {
        if (index == word.length)
            return true;

        if (row < 0 || col < 0 || row == board.length || col == board[0].length
                || board[row][col] != word[index] || visited[row][col])
            return false;

        visited[row][col] = true;

        for (int i = 0; i < 4; ++i) {
            if (found(board, row + dirs[i], col + dirs[i + 1],
                    word, visited, index + 1))
                return true;
        }

        visited[row][col] = false;
        return false;
    }
}
