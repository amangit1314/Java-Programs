package graphs;
import java.util.*;

// Problem Title => Journey to the Moon
public class Graph_Problem_31 {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_31(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // Since the graph is undirected
    }

    // A utility function to perform DFS and return the size of the connected component
    int DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        int size = 1;
        for (int n : adj[v]) {
            if (!visited[n])
                size += DFSUtil(n, visited);
        }
        return size;
    }

    // Function to find the number of ways to choose a pair of astronauts from different countries
    int journeyToMoon() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        List<Integer> componentSizes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                int size = DFSUtil(i, visited);
                componentSizes.add(size);
            }
        }

        int totalPairs = (V * (V - 1)) / 2;
        int sameCountryPairs = 0;
        for (int size : componentSizes) {
            sameCountryPairs += (size * (size - 1)) / 2;
        }

        return totalPairs - sameCountryPairs;
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_31 g = new Graph_Problem_31(5);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(0, 4);

        System.out.println("Number of ways to choose a pair of astronauts from different countries: " + g.journeyToMoon());
    }
}

/*
Approach:
1. The problem is to find the number of ways to choose a pair of astronauts from different countries.
2. This can be solved using Depth-First Search (DFS) to find the sizes of all connected components in the graph.
3. The algorithm involves the following steps:
   a. Perform DFS to find the size of each connected component.
   b. Calculate the total number of ways to choose a pair of astronauts.
   c. Subtract the number of ways to choose a pair of astronauts from the same country.

Notes:
- The graph is represented as an adjacency list.
- The function `journeyToMoon` finds the number of ways to choose a pair of astronauts from different countries.
- The function `addEdge` adds an edge to the graph.
- The function `DFSUtil` performs DFS and returns the size of the connected component.

Example:
Input:
Graph (Adjacency List):
0 -> 1
2 -> 3
0 -> 4

Output:
Number of ways to choose a pair of astronauts from different countries: 6

Explanation:
- The graph contains three connected components: {0, 1, 4}, {2, 3}, and {5}.
- The number of ways to choose a pair of astronauts from different countries is 6.
*/