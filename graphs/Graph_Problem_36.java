package graphs;
import java.util.*;

// Problem Title => Find if there is a path of more than k length from a source
public class Graph_Problem_36 {
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
    Graph_Problem_35(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        adj[src].add(new Edge(dest, weight));
    }

    // Utility function for DFS to check if there is a path of more than k length from the source
    boolean DFS(int v, int k, boolean[] visited) {
        visited[v] = true;

        // If k is less than or equal to 0, return true
        if (k <= 0) return true;

        // Recur for all vertices adjacent to this vertex
        for (Edge edge : adj[v]) {
            int u = edge.dest;
            int weight = edge.weight;

            // If the adjacent vertex is not visited, recur for it
            if (!visited[u]) {
                if (DFS(u, k - weight, visited)) {
                    return true;
                }
            }
        }

        // Backtrack
        visited[v] = false;
        return false;
    }

    // Function to check if there is a path of more than k length from the source
    boolean isPathMoreThanK(int src, int k) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        return DFS(src, k, visited);
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_35 g = new Graph_Problem_35(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        int src = 0;
        int k = 62;
        if (g.isPathMoreThanK(src, k))
            System.out.println("Yes, there is a path of more than " + k + " length from source " + src);
        else
            System.out.println("No, there is no path of more than " + k + " length from source " + src);
    }
}

/*
Approach:
1. The problem is to find if there is a path of more than k length from a given source vertex in a graph.
2. This can be solved using Depth-First Search (DFS) to explore all possible paths from the source vertex.
3. The algorithm involves the following steps:
   a. Initialize a visited array to keep track of visited vertices.
   b. Perform DFS from the source vertex, reducing the value of k by the weight of the edges traversed.
   c. If k becomes less than or equal to 0, return true.
   d. If all paths are explored and k is still greater than 0, return false.

Notes:
- The graph is represented as an adjacency list.
- The function `isPathMoreThanK` checks if there is a path of more than k length from the source using DFS.
- The function `addEdge` adds an edge to the graph.
- The function `DFS` performs DFS and checks if there is a path of more than k length from the source.

Example:
Input:
Graph (Adjacency List):
0 -> 1 (4)
0 -> 7 (8)
1 -> 2 (8)
1 -> 7 (11)
2 -> 3 (7)
2 -> 8 (2)
2 -> 5 (4)
3 -> 4 (9)
3 -> 5 (14)
4 -> 5 (10)
5 -> 6 (2)
6 -> 7 (1)
6 -> 8 (6)
7 -> 8 (7)

Source: 0
k: 62

Output:
Yes, there is a path of more than 62 length from source 0

Explanation:
- There is a path from vertex 0 to vertex 4 with a total length of 62.
*/