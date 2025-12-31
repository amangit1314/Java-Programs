package graphs;

import java.util.LinkedList;

/**
 * Depth-first search (DFS) implementation for graph traversal.
 * The algorithm starts at a given node and explores as far as possible along
 * each branch before backtracking.
 */
public class DFSTraversal {
    private int numberOfVertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list for the graph

    DFSTraversal(int vertices) {
        numberOfVertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int vertex, int adjacentVertex) {
        adjacencyList[vertex].add(adjacentVertex);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int adjacentVertex : adjacencyList[vertex]) {
            if (!visited[adjacentVertex]) {
                DFSUtil(adjacentVertex, visited);
            }
        }
    }

    public void DFS(int startVertex) {
        // Mark all the vertices as not visited (set as false by default)
        boolean[] visited = new boolean[numberOfVertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        DFSTraversal graph = new DFSTraversal(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2):");
        graph.DFS(2);
    }
}
