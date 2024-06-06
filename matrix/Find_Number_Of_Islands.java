package matrix;

public class Find_Number_Of_Islands {
    static int n, m;

    // valid row and column checker
    static boolean check(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    static void mark_component(int[][] v, boolean[][] vis,
            int i, int j) {

        if (!check(i, j))
            return;

        vis[i][j] = true;

        // marking (connecting all possible parts of single island)
        if (v[i][j] == 1) {
            v[i][j] = 0;
            mark_component(v, vis, i + 1, j);
            mark_component(v, vis, i - 1, j);
            mark_component(v, vis, i, j + 1);
            mark_component(v, vis, i, j - 1);
            mark_component(v, vis, i + 1, j + 1);
            mark_component(v, vis, i - 1, j - 1);
            mark_component(v, vis, i + 1, j - 1);
            mark_component(v, vis, i - 1, j + 1);
        }
    }

    public static void main(String[] args) {
        int[][] v = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        n = v.length;
        m = v[0].length;
        int cnt = 0;

        // visit vector
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && v[i][j] == 1) {
                    ++cnt;
                    mark_component(v, vis, i, j);
                }
            }
        }

        System.out.println(
                "The number of islands in the matrix are: ");
        System.out.println(cnt);
    }
}
