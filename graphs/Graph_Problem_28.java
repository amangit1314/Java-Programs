package graphs;
import java.util.*;
import java.util.LinkedList;

// Problem Title => Check whether a graph is Bipartite or Not
public class Graph_Problem_28 {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_28(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
        adj[w].add(v); // Add v to w's list (since the graph is undirected).
    }

    // Function to check whether a graph is Bipartite or not using BFS
    boolean isBipartite(int src) {
        // Create a color array to store colors assigned to all vertices.
        // -1 means no color is assigned yet.
        int colorArr[] = new int[V];
        Arrays.fill(colorArr, -1);

        // Assign the first color to the source vertex
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and enqueue source vertex for BFS traversal
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);

        // Run while there are vertices in the queue (similar to BFS)
        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Return false if there is a self-loop
            if (adj[u].contains(u))
                return false;

            // Find all non-colored adjacent vertices
            for (int v : adj[u]) {
                // If the adjacent vertex v is not colored, assign alternate color to it
                if (colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    queue.add(v);
                }
                // If the adjacent vertex v is colored with the same color as u, then the graph is not Bipartite
                else if (colorArr[v] == colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can be colored with alternate color
        return true;
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_28 g = new Graph_Problem_28(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        if (g.isBipartite(0))
            System.out.println("Yes, the graph is Bipartite");
        else
            System.out.println("No, the graph is not Bipartite");
    }
}

/*
Approach:
1. The problem is to check whether a given graph is Bipartite or not.
2. A graph is Bipartite if we can split its set of vertices into two independent subsets such that no two vertices within the same subset are adjacent.
3. This can be solved using BFS. We start with the first vertex and assign it a color. We then move to its adjacent vertices and assign them an alternate color.
4. If we find an adjacent vertex with the same color as the current vertex, the graph is not Bipartite.

Notes:
- The graph is represented as an adjacency list.
- The function `isBipartite` checks if the graph is Bipartite using BFS.
- The function `addEdge` adds an edge to the graph.

Example:
Input:
Graph (Adjacency List):
0 -> 1, 3
1 -> 0, 2
2 -> 1, 3
3 -> 0, 2

Output:
Yes, the graph is Bipartite

Explanation:
- The graph can be divided into two sets {0, 2} and {1, 3} such that no two vertices within the same set are adjacent.
*/