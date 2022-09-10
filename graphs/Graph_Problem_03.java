package graphs;
import java.util.*;

/*
 * Problem Title :-> Implement Graph DFS Algorithm
 * This class represents a directed graph using adjacency linkedList.list representation
 */
public class Graph_Problem_03{

	// Array of lists for "Adjacency List Representation".
	private final LinkedList<Integer>[] adj;
	
	// Constructor
	@SuppressWarnings("unchecked")
	public Graph_Problem_03(int v){
		// No. of vertices
		adj = new LinkedList[v];
		for(int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}
	
	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		// Add w to v's linkedList.list.
		adj[v].add(w);		
	}
	
	// A function used by DFS
	void DFSUtil(int v, boolean[] visited) {
		
		//Mark the current node as visited & print it
		visited[v] = true;
		System.out.println(v + " ");
		
		// Recur for all the vertices adjacent to this vertex
		for (int n : adj[v]) {
			if (!visited[n])
				DFSUtil(n, visited);
		}	
	}
	
	// The function do DFS traversal. It uses recursive DFSUtil().
	void DFS() {
		boolean[] visited = new boolean[2];
		DFSUtil(2,visited);
	}
	
	// Driver Code
	public static void main(String[] args) {

		//Making Object of Graph_Problem_03 class
		Graph_Problem_03 d = new Graph_Problem_03(4);
		
		// Adding edges one by one 
        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 2);
        d.addEdge(2, 0);
        d.addEdge(2, 3);
        d.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
 
        //Calling DFS method by using class object d
        d.DFS();
		
	}

}
