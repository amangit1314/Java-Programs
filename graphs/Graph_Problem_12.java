package graphs;
import java.util.*;

// Problem Title => Dijkstra's Algorithm (Find The Shortest Path)
public class Graph_Problem_12 {
    // finding vertex with min distance,
    // from set of non-included vertices in the shortest path tree
    int minDistance(int[] dist, boolean[] sptSet, int V){
        // Initializing the min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v = 0; v < V; v++){
            if(!sptSet[v] && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printSolution(int[] dist, int V){
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijskstra(int[][] graph, int V){
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[0] = 0;

        for(int count = 0; count < V -1; count++){
            int u = minDistance(dist, sptSet, V);

            sptSet[u] = true;

            for(int v = 0; v < V; v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }

            printSolution(dist, V);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();


        int[][] graph = new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        Graph_Problem_12 t = new Graph_Problem_12 ();
        t.dijskstra(graph, V);
    }
}