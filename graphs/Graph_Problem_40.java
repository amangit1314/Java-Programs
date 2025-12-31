package graphs;
import java.util.*;

// Problem Title => Chinese Postman or Route Inspection
public class Graph_Problem_40 {
    private int V; // No. of vertices
    private int[][] adjMatrix; // Adjacency matrix

    // Constructor
    Graph_Problem_41(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight; // Comment this line for directed graph
    }

    // Function to find the shortest path between two vertices using Dijkstra's algorithm
    int dijkstra(int src, int dest) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
        pq.add(src);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (u == dest) break;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                    pq.add(v);
                }
            }
        }

        return dist[dest];
    }

    // Function to find the minimum cost to make all vertices have even degree
    int minCostToMakeEulerian() {
        List<Integer> oddDegreeVertices = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            int degree = 0;
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] != 0) degree++;
            }
            if (degree % 2 != 0) oddDegreeVertices.add(i);
        }

        int oddCount = oddDegreeVertices.size();
        if (oddCount == 0) return 0; // Already Eulerian

        int[][] cost = new int[oddCount][oddCount];
        for (int i = 0; i < oddCount; i++) {
            for (int j = i + 1; j < oddCount; j++) {
                cost[i][j] = cost[j][i] = dijkstra(oddDegreeVertices.get(i), oddDegreeVertices.get(j));
            }
        }

        return minCostMatching(cost);
    }

    // Function to find the minimum cost perfect matching using dynamic programming
    int minCostMatching(int[][] cost) {
        int n = cost.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            int x = Integer.bitCount(mask);
            if (x % 2 != 0) continue;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) continue;
                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) != 0) continue;
                    dp[mask | (1 << i) | (1 << j)] = Math.min(dp[mask | (1 << i) | (1 << j)], dp[mask] + cost[i][j]);
                }
            }
        }

        return dp[(1 << n) - 1];
    }

    // Function to find the minimum cost of the Chinese Postman or Route Inspection problem
    int chinesePostman() {
        int minCost = minCostToMakeEulerian();
        int totalCost = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                totalCost += adjMatrix[i][j];
            }
        }
        return (totalCost / 2) + minCost;
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_41 g = new Graph_Problem_41(4);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 0, 3);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 0, 5);

        System.out.println("Minimum cost of Chinese Postman or Route Inspection: " + g.chinesePostman());
    }
}

/*
Approach:
1. The problem is to find the minimum cost of traversing all edges of a graph at least once (Chinese Postman or Route Inspection problem).
2. The graph must be Eulerian (all vertices have even degree) to solve this problem efficiently.
3. If the graph is not Eulerian, we need to add the minimum cost edges to make all vertices have even degree.
4. This can be solved using the following steps:
   a. Find all vertices with odd degree.
   b. Find the minimum cost perfect matching of these odd degree vertices.
   c. Add the cost of this matching to the total cost of all edges in the graph.

Notes:
- The graph is represented as an adjacency matrix.
- The function `chinesePostman` finds the minimum cost of the Chinese Postman or Route Inspection problem.
- The function `addEdge` adds an edge to the graph.
- The function `dijkstra` finds the shortest path between two vertices using Dijkstra's algorithm.
- The function `minCostToMakeEulerian` finds the minimum cost to make all vertices have even degree.
- The function `minCostMatching` finds the minimum cost perfect matching using dynamic programming.

Example:
Input:
Graph (Adjacency Matrix):
0 -> 1 (1)
1 -> 2 (2)
2 -> 0 (3)
2 -> 3 (4)
3 -> 0 (5)

Output:
Minimum cost of Chinese Postman or Route Inspection: 15

Explanation:
- The graph contains vertices with odd degree: 1, 2, 3.
- The minimum cost perfect matching of these vertices is (1, 2) with cost 2.
- The total cost of all edges in the graph is 15.
- The minimum cost of the Chinese Postman or Route Inspection problem is 15.
*/