package graphs;
import java.util.*;

// Problem Title => Number of Triangles in a Directed and Undirected Graph
public class Graph_Problem_41 {
    private int V; // No. of vertices
    private int[][] adjMatrix; // Adjacency matrix

    // Constructor
    Graph_Problem_42(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // Comment this line for directed graph
    }

    // Function to count the number of triangles in an undirected graph
    int countTrianglesUndirected() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (adjMatrix[i][j] == 1 && adjMatrix[j][k] == 1 && adjMatrix[k][i] == 1) {
                        count++;
                    }
                }
            }
        }
        return count / 3; // Each triangle is counted 3 times
    }

    // Function to count the number of triangles in a directed graph
    int countTrianglesDirected() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (adjMatrix[i][j] == 1 && adjMatrix[j][k] == 1 && adjMatrix[k][i] == 1) {
                        count++;
                    }
                }
            }
        }
        return count; // Each triangle is counted once
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_42 g = new Graph_Problem_42(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.println("Number of triangles in undirected graph: " + g.countTrianglesUndirected());
        System.out.println("Number of triangles in directed graph: " + g.countTrianglesDirected());
    }
}

/*
Approach:
1. The problem is to count the number of triangles in a given graph.
2. A triangle is a set of three vertices such that there is an edge between every pair of vertices.
3. For an undirected graph, each triangle is counted three times (once at each vertex), so we divide the count by 3.
4. For a directed graph, each triangle is counted once.

Notes:
- The graph is represented as an adjacency matrix.
- The function `countTrianglesUndirected` counts the number of triangles in an undirected graph.
- The function `countTrianglesDirected` counts the number of triangles in a directed graph.
- The function `addEdge` adds an edge to the graph.

Example:
Input:
Graph (Adjacency Matrix):
0 -> 1
1 -> 2
2 -> 0
2 -> 3
3 -> 0

Output:
Number of triangles in undirected graph: 1
Number of triangles in directed graph: 1

Explanation:
- The graph contains one triangle: 0 -> 1 -> 2 -> 0.
*/