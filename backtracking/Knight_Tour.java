package backtracking;
// Knight tour problem
public class Knight_Tour {

    static boolean isSafe(int x, int y, int sol[][], int N) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // A utility function to print solution matrix sol[N][N]
    static void printSolution(int sol[][], int N) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public static void solve(int n, int i, int j, int cnt, boolean[][] visited){
        int[][] mat = new int[i][j];
        if(i < 0 || j < 0 || i >= n || j >= n)
            return;
        if(visited[i][j]) return;
        if(cnt == (n*n-1)){
            mat[i][j] = cnt;
            return;
        }
        visited[i][j] = true;
        mat[i][j] = cnt;

        solve(n,i-2,j+1,cnt+1,visited);
        solve(n,i-2,j-1,cnt+1,visited);
        solve(n,i+2,j+1,cnt+1,visited);
        solve(n,i+2,j-1,cnt+1,visited);
        solve(n,i-1,j+2,cnt+1,visited);
        solve(n,i-1,j-2,cnt+1,visited);
        solve(n,i+1,j+2,cnt+1,visited);
        solve(n,i-1,j-2,cnt+1,visited);

        visited[i][j] = false;
        return;
    }
    public static void main(String[] args) {

    }
}

/*
* */