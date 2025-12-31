package graphs;
import java.util.*;

// Problem Title => Minimum edges to reverse to make path from source to destination
public class Graph_Problem_37 {
    private int V; // No. of vertices
    private LinkedList<Edge>[] adj; // Adjacency list

    // Edge class to represent a directed edge with a destination and weight
    class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_38(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adj[src].add(new Edge(dest, 0)); // Original edge with weight 0
        adj[dest].add(new Edge(src, 1)); // Reverse edge with weight 1
    }

    // Function to find the minimum edges to reverse to make path from source to destination using BFS
    int minEdgesToReverse(int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Edge edge : adj[u]) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    queue.add(v);
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_38 g = new Graph_Problem_38(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 3);
        g.addEdge(5, 4);
        g.addEdge(1, 5);

        int src = 0;
        int dest = 3;
        int result = g.minEdgesToReverse(src, dest);
        if (result != -1)
            System.out.println("Minimum edges to reverse to make path from " + src + " to " + dest + ": " + result);
        else
            System.out.println("No path exists from " + src + " to " + dest);
    }
}

/*
Approach:
1. The problem is to find the minimum number of edges to reverse to make a path from a given source vertex to a destination vertex in a directed graph.
2. This can be solved using Breadth-First Search (BFS) to explore all possible paths from the source vertex.
3. The algorithm involves the following steps:
   a. Initialize a distance array to keep track of the minimum number of edges to reverse to reach each vertex.
   b. Add both the original edge (with weight 0) and the reverse edge (with weight 1) to the adjacency list.
   c. Perform BFS from the source vertex, updating the distance array based on the weight of the edges traversed.
   d. If the destination vertex is reached, return the distance value. If the queue is exhausted without reaching the destination, return -1.

Notes:
- The graph is represented as an adjacency list.
- The function `minEdgesToReverse` finds the minimum edges to reverse to make a path from source to destination using BFS.
- The function `addEdge` adds an edge to the graph, including both the original and reverse edges.

Example:
Input:
Graph (Adjacency List):
0 -> 1
1 -> 2
2 -> 3
4 -> 3
5 -> 4
1 -> 5

Source: 0
Destination: 3

Output:
Minimum edges to reverse to make path from 0 to 3: 1

Explanation:
- The minimum number of edges to reverse to make a path from vertex 0 to vertex 3 is 1 (reverse edge 4 -> 3).
*/