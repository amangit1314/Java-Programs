package graphs;
import java.util.*;

// Problem Title => Flood Fill Algo using BFS

class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return second - o.second;
    }
}
public class Graph_Problem_08 {

    public static int validCoord(int x, int y, int n, int m){
        if(x < 0 || y < 0)
            return 0;
        if(x >= n || y >= m)
            return 0;
        return 1;
    }

    public static void bfs(int n, int m, int[][] data, int x, int y, int color){
        int[][] vis = new int[101][101];

        for(int i = 0; i <= 100; i++)
            for(int j = 0; j <= 100; j++)
                vis[i][j] = 0;

        // Creating queue for bfs
        Queue<Pair> obj = new LinkedList<>();

        //Publishing a pair of (x,y)
        Pair pq = new Pair(x,y);
        obj.add(pq);

        // Marking (x, y) as visited
        vis[x][y] = 1;

        while (!obj.isEmpty()){
            //Extracting front pair
            Pair coord = obj.peek();
            int x1 = coord.first;
            int y1 = coord.second;
            int preColor = data[x1][y1];

            data[x1][y1] = color;
            obj.remove();

            // For Upside Pixel or Cell
            if ((validCoord(x1 + 1, y1, n, m)==1) && vis[x1 + 1][y1] == 0 && data[x1 + 1][y1] == preColor) {
                Pair p=new Pair(x1 +1, y1);
                obj.add(p);
                vis[x1 + 1][y1] = 1;
            }

            // For Downside Pixel or Cell
            if ((validCoord(x1 - 1, y1, n, m)==1) && vis[x1 - 1][y1] == 0 && data[x1 - 1][y1] == preColor) {
                Pair p=new Pair(x1-1,y1);
                obj.add(p);
                vis[x1- 1][y1] = 1;
            }

            // For Right side Pixel or Cell
            if ((validCoord(x1, y1 + 1, n, m)==1) && vis[x1][y1 + 1] == 0 && data[x1][y1 + 1] == preColor) {
                Pair p=new Pair(x1,y1 +1);
                obj.add(p);
                vis[x1][y1 + 1] = 1;
            }

            // For Left side Pixel or Cell
            if ((validCoord(x1, y1 - 1, n, m)==1) && vis[x1][y1 - 1] == 0 && data[x1][y1 - 1] == preColor) {
                Pair p=new Pair(x1,y1 -1);
                obj.add(p);
                vis[x1][y1 - 1] = 1;
            }

            // Printing The Changed Matrix Of Pixels
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    System.out.print(data[i][j]+" ");
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nn, mm, xx, yy, colorr;
        nn = 8;
        mm = 8;

        int[][] data = {
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 1, 1 },
                { 1, 2, 2, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 2, 2, 0 },
                { 1, 1, 1, 1, 1, 2, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 2, 1 },
        };

        xx = 4; yy = 4; colorr = 3;

        // Function Call
        bfs(nn, mm, data, xx, yy, colorr);
    }
}