package graphs;
import java.util.*;
import java.util.LinkedList;

// Problem Title => Kosaraju's Algorithm for Strongly Connected Components (SCCs)
public class Graph_Problem_27 {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_27(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // A function to perform DFS and fill the stack with vertices in the order of their finishing times
    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(v);
    }

    // A function to perform DFS on the transposed graph
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Function to get the transpose of the graph
    Graph_Problem_27 getTranspose() {
        Graph_Problem_27 g = new Graph_Problem_27(V);
        for (int v = 0; v < V; v++) {
            for (int n : adj[v]) {
                g.adj[n].add(v);
            }
        }
        return g;
    }

    // The main function that finds and prints all SCCs
    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        // Create a reversed graph
        Graph_Problem_27 gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Now process all vertices in order defined by Stack
        while (!stack.isEmpty()) {
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_27 g = new Graph_Problem_27(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components in the given graph ");
        g.printSCCs();
    }
}

/*
Approach:
1. The problem is to find all Strongly Connected Components (SCCs) in a directed graph.
2. Kosaraju's Algorithm is used to solve this problem. It involves two main steps:
   a. Perform a DFS on the original graph and push vertices onto a stack in the order of their finishing times.
   b. Transpose the graph (reverse the direction of all edges) and perform DFS on the transposed graph in the order defined by the stack.
3. Each DFS on the transposed graph will give one SCC.

Notes:
- The graph is represented as an adjacency list.
- The function `fillOrder` performs DFS and fills the stack with vertices in the order of their finishing times.
- The function `DFSUtil` performs DFS on the transposed graph.
- The function `getTranspose` returns the transposed graph.
- The function `printSCCs` finds and prints all SCCs using Kosaraju's Algorithm.

Example:
Input:
Graph (Adjacency List):
0 -> 2 -> 3
1 -> 0
2 -> 1
3 -> 4

Output:
Following are strongly connected components in the given graph
0 1 2
3
4

Explanation:
- The SCCs in the given graph are {0, 1, 2}, {3}, and {4}.
*/