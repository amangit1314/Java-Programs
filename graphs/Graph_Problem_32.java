package graphs;
import java.util.*;

// Problem Title => Cheapest Flights Within K Stops
public class Graph_Problem_32 {
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
    Graph_Problem_32(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        adj[src].add(new Edge(dest, weight));
    }

    // Function to find the cheapest flight within K stops using BFS
    int findCheapestPrice(int src, int dst, int K) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0}); // {current node, current cost, current stops}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0], cost = current[1], stops = current[2];

            if (stops > K) continue;

            for (Edge edge : adj[u]) {
                int v = edge.dest, weight = edge.weight;
                if (cost + weight < dist[v]) {
                    dist[v] = cost + weight;
                    queue.add(new int[]{v, dist[v], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph_Problem_32 g = new Graph_Problem_32(5);
        g.addEdge(0, 1, 100);
        g.addEdge(1, 2, 100);
        g.addEdge(2, 3, 100);
        g.addEdge(0, 2, 500);
        g.addEdge(3, 4, 100);

        int src = 0, dst = 3, K = 1;
        System.out.println("Cheapest price within " + K + " stops: " + g.findCheapestPrice(src, dst, K));
    }
}

/*
Approach:
1. The problem is to find the cheapest flight from a source to a destination with at most K stops.
2. This can be solved using Breadth-First Search (BFS) to explore all possible paths within K stops.
3. The algorithm involves the following steps:
   a. Initialize the distance to all vertices as infinity and the distance to the source as 0.
   b. Use a queue to perform BFS, where each element in the queue is a triplet {current node, current cost, current stops}.
   c. For each node, update the distance to its adjacent nodes if a cheaper path is found and add the adjacent nodes to the queue.
   d. If the number of stops exceeds K, continue to the next node in the queue.

Notes:
- The graph is represented as an adjacency list.
- The function `findCheapestPrice` finds the cheapest flight within K stops using BFS.
- The function `addEdge` adds an edge to the graph.

Example:
Input:
Graph (Adjacency List):
0 -> 1 (100)
1 -> 2 (100)
2 -> 3 (100)
0 -> 2 (500)
3 -> 4 (100)

Source: 0
Destination: 3
K: 1

Output:
Cheapest price within 1 stops: 500

Explanation:
- The cheapest flight from 0 to 3 with at most 1 stop is 0 -> 2 -> 3 with a total cost of 500.
*/