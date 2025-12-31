package graphs;
import java.util.*;

// Problem Title => Oliver and the Game
public class Graph_Problem_33 {
    private int V; // No. of vertices
    private LinkedList<Integer>[] adj; // Adjacency list
    private int[] inTime, outTime;
    private int timer;

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_33(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
        inTime = new int[v];
        outTime = new int[v];
        timer = 0;
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // Since the graph is undirected
    }

    // Function to perform DFS and calculate in-time and out-time for each vertex
    void DFS(int v, boolean visited[]) {
        visited[v] = true;
        inTime[v] = ++timer;
        for (int n : adj[v]) {
            if (!visited[n])
                DFS(n, visited);
        }
        outTime[v] = ++timer;
    }

    // Function to check if u is an ancestor of v
    boolean isAncestor(int u, int v) {
        return inTime[u] < inTime[v] && outTime[u] > outTime[v];
    }

    // Function to process queries
    String processQuery(int type, int x, int y) {
        if (type == 0) {
            return isAncestor(x, y) ? "YES" : "NO";
        } else {
            return isAncestor(y, x) ? "YES" : "NO";
        }
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_33 g = new Graph_Problem_33(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        boolean[] visited = new boolean[7];
        Arrays.fill(visited, false);
        g.DFS(0, visited);

        // Example queries
        System.out.println(g.processQuery(0, 1, 3)); // YES
        System.out.println(g.processQuery(1, 1, 3)); // NO
        System.out.println(g.processQuery(0, 2, 5)); // YES
        System.out.println(g.processQuery(1, 2, 5)); // NO
    }
}

/*
Approach:
1. The problem is to determine if one node is an ancestor of another in a tree.
2. This can be solved using Depth-First Search (DFS) to calculate the in-time and out-time for each vertex.
3. The algorithm involves the following steps:
   a. Perform DFS to calculate the in-time and out-time for each vertex.
   b. For each query, check if one node is an ancestor of another using the in-time and out-time values.

Notes:
- The graph is represented as an adjacency list.
- The function `DFS` performs DFS and calculates the in-time and out-time for each vertex.
- The function `isAncestor` checks if one node is an ancestor of another.
- The function `processQuery` processes the queries.

Example:
Input:
Graph (Adjacency List):
0 -> 1
0 -> 2
1 -> 3
1 -> 4
2 -> 5
2 -> 6

Queries:
(0, 1, 3)
(1, 1, 3)
(0, 2, 5)
(1, 2, 5)

Output:
YES
NO
YES
NO

Explanation:
- For the first query, node 1 is an ancestor of node 3.
- For the second query, node 1 is not a descendant of node 3.
- For the third query, node 2 is an ancestor of node 5.
- For the fourth query, node 2 is not a descendant of node 5.
*/