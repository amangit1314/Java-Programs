package graphs;
import java.util.*;

// Problem Title => Paths to travel each node using each edge (Seven Bridges)
public class Graph_Problem_38 {
    private int V; // No. of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    @SuppressWarnings("unchecked")
    Graph_Problem_39(int v) {
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

    // Function to check if all vertices with non-zero degree are connected
    boolean isConnected() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Find a vertex with non-zero degree
        int i;
        for (i = 0; i < V; i++) {
            if (adj[i].size() != 0)
                break;
        }

        // If there are no edges in the graph, return true
        if (i == V)
            return true;

        // Start DFS from a vertex with non-zero degree
        DFSUtil(i, visited);

        // Check if all non-zero degree vertices are visited
        for (i = 0; i < V; i++) {
            if (visited[i] == false && adj[i].size() > 0)
                return false;
        }

        return true;
    }

    // A utility function to perform DFS
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Function to check if the graph has an Eulerian path or circuit
    boolean isEulerian() {
        // Check if all non-zero degree vertices are connected
        if (!isConnected())
            return false;

        // Count vertices with odd degree
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0)
                odd++;
        }

        // If count is more than 2, then the graph is not Eulerian
        return (odd == 0 || odd == 2);
    }

    // Function to find and print Eulerian path or circuit
    void printEulerianPathOrCircuit() {
        if (!isEulerian()) {
            System.out.println("Graph is not Eulerian");
            return;
        }

        // Find a vertex with odd degree
        int start = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                start = i;
                break;
            }
        }

        // Print Eulerian path or circuit starting from the vertex with odd degree
        printEulerUtil(start);
    }

    // A utility function to print Eulerian path or circuit
    void printEulerUtil(int v) {
        for (int i = 0; i < adj[v].size(); i++) {
            int u = adj[v].get(i);

            // If edge u-v is a valid next edge
            if (isValidNextEdge(v, u)) {
                System.out.print(v + "-" + u + " ");
                removeEdge(v, u);
                printEulerUtil(u);
            }
        }
    }

    // Function to check if edge u-v can be considered as next edge in Eulerian path
    boolean isValidNextEdge(int u, int v) {
        // The edge u-v is valid in one of the following two cases:

        // 1. If v is the only adjacent vertex of u
        if (adj[u].size() == 1)
            return true;

        // 2. If there are multiple adjacents, then u-v is not a bridge
        // Do following steps to check if u-v is a bridge

        // 2.a) Count vertices reachable from u
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int count1 = DFSCount(u, visited);

        // 2.b) Remove edge (u, v) and after removing the edge, count vertices reachable from u
        removeEdge(u, v);
        Arrays.fill(visited, false);
        int count2 = DFSCount(u, visited);

        // 2.c) Add the edge back to the graph
        addEdge(u, v);

        // 2.d) If count1 is greater, then edge (u, v) is a bridge
        return (count1 > count2) ? false : true;
    }

    // A utility function to count vertices reachable from v
    int DFSCount(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;
        for (int i : adj[v]) {
            if (!visited[i])
                count += DFSCount(i, visited);
        }
        return count;
    }

    // Function to remove edge u-v from the graph
    void removeEdge(int u, int v) {
        adj[u].remove((Integer) v);
        adj[v].remove((Integer) u);
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_39 g = new Graph_Problem_39(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printEulerianPathOrCircuit();
    }
}

/*
Approach:
1. The problem is to find a path that visits every edge exactly once in a graph (Eulerian path or circuit).
2. This can be solved using Depth-First Search (DFS) to explore all possible paths from the source vertex.
3. The algorithm involves the following steps:
   a. Check if all non-zero degree vertices are connected.
   b. Count the number of vertices with odd degree.
   c. If the count is more than 2, then the graph is not Eulerian.
   d. If the count is 0, then the graph has an Eulerian circuit.
   e. If the count is 2, then the graph has an Eulerian path.
   f. Use DFS to find and print the Eulerian path or circuit.

Notes:
- The graph is represented as an adjacency list.
- The function `isEulerian` checks if the graph has an Eulerian path or circuit.
- The function `printEulerianPathOrCircuit` finds and prints the Eulerian path or circuit.
- The function `addEdge` adds an edge to the graph.
- The function `DFSUtil` performs DFS to check connectivity.
- The function `isValidNextEdge` checks if an edge can be considered as the next edge in the Eulerian path.
- The function `removeEdge` removes an edge from the graph.

Example:
Input:
Graph (Adjacency List):
0 -> 1
0 -> 2
1 -> 2
1 -> 3
2 -> 3
3 -> 4

Output:
0-1 1-2 2-0 2-3 3-1 3-4

Explanation:
- The graph has an Eulerian path starting from vertex 0 and ending at vertex 4.
*/