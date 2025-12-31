package graphs;
import java.util.*;

// Problem Title => Find the Longest Path in a Directed Acyclic Graph (DAG)
public class Graph_Problem_30 {
    private int V; // No. of vertices
    private LinkedList<Edge> adj[]; // Adjacency list

    // Edge class to represent a directed edge with a source, destination, and weight
    class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_30(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        adj[src].add(new Edge(dest, weight));
    }

    // A utility function to perform topological sort
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (Edge edge : adj[v]) {
            if (!visited[edge.dest])
                topologicalSortUtil(edge.dest, visited, stack);
        }
        stack.push(v);
    }

    // Function to find the longest path in the DAG
    void longestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[V];

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Perform topological sort
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Initialize distances to all vertices as minus infinite and distance to source as 0
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (Edge edge : adj[u]) {
                    if (dist[edge.dest] < dist[u] + edge.weight) {
                        dist[edge.dest] = dist[u] + edge.weight;
                    }
                }
            }
        }

        // Print the calculated longest distances
        System.out.println("Longest distances from source vertex " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MIN_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_30 g = new Graph_Problem_30(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are longest distances from source vertex " + s);
        g.longestPath(s);
    }
}

/*
Approach:
1. The problem is to find the longest path in a Directed Acyclic Graph (DAG).
2. This can be solved using topological sorting and dynamic programming. The algorithm involves the following steps:
   a. Perform topological sorting of the vertices.
   b. Initialize distances to all vertices as minus infinity and distance to the source vertex as 0.
   c. Process vertices in topological order and update the distances of adjacent vertices.

Notes:
- The graph is represented as an adjacency list.
- The function `longestPath` finds the longest path in the DAG.
- The function `addEdge` adds an edge to the graph.
- The function `topologicalSortUtil` performs topological sorting.

Example:
Input:
Graph (Edges with Weights):
0 -> 1 (5)
0 -> 2 (3)
1 -> 3 (6)
1 -> 2 (2)
2 -> 4 (4)
2 -> 5 (2)
2 -> 3 (7)
3 -> 5 (1)
3 -> 4 (-1)
4 -> 5 (-2)

Output:
Longest distances from source vertex 1:
INF 0 2 6 5 3

Explanation:
- The longest path from vertex 1 to vertex 5 is 1 -> 2 -> 3 -> 5 with a total weight of 6 + 7 + 1 = 14.
*/