package graphs;
import java.util.*;

// Problem Title => Detect Negative Cycle in a Graph using Bellman-Ford Algorithm
public class Graph_Problem_29 {
    private int V; // No. of vertices
    private LinkedList<Edge> edges; // List of all edges

    // Edge class to represent a directed edge with a source, destination, and weight
    class Edge {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    Graph_Problem_29(int v) {
        V = v;
        edges = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Function to detect a negative cycle in the graph using Bellman-Ford Algorithm
    boolean isNegativeCycle(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return true; // Negative cycle detected
            }
        }

        return false; // No negative cycle detected
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_29 g = new Graph_Problem_29(5);
        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        if (g.isNegativeCycle(0))
            System.out.println("Yes, the graph contains a negative cycle");
        else
            System.out.println("No, the graph does not contain a negative cycle");
    }
}

/*
Approach:
1. The problem is to detect whether a given graph contains a negative cycle or not.
2. A negative cycle is a cycle in a graph where the sum of the edge weights is negative.
3. This can be solved using the Bellman-Ford algorithm. The algorithm involves the following steps:
   a. Initialize the distance to the source vertex as 0 and all other vertices as infinity.
   b. Relax all edges |V| - 1 times, where |V| is the number of vertices.
   c. Check for negative-weight cycles by verifying if any edge can be further relaxed.

Notes:
- The graph is represented as a list of edges.
- The function `isNegativeCycle` detects if the graph contains a negative cycle using the Bellman-Ford algorithm.
- The function `addEdge` adds an edge to the graph.

Example:
Input:
Graph (Edges with Weights):
0 -> 1 (-1)
0 -> 2 (4)
1 -> 2 (3)
1 -> 3 (2)
1 -> 4 (2)
3 -> 2 (5)
3 -> 1 (1)
4 -> 3 (-3)

Output:
Yes, the graph contains a negative cycle

Explanation:
- The graph contains a negative cycle: 1 -> 4 -> 3 -> 1 with a total weight of -1 + (-3) + 1 = -3.
*/