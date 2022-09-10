package graphs;
import java.util.*;

// Problem Title -> Implement BFS Algorithm of Traversal of Graph.
public class Graph_Problem_02 {
	// No. of vertices.
	private final int V;

	// Adjacency List
	private final LinkedList<Integer>[] adj;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// Constructor
	Graph_Problem_02(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
	
	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By Default set as false)
		boolean[] visited = new boolean[V];
		
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();

		// mark visited arrays.array as true
		visited[s] = true;

		// add it to queue
		queue.add(s);
		
		while(queue.size() != 0) {
			// Dequeue a vertex from queue and print
			s = queue.poll();
			System.out.println(s + " ");
			
			// Get all adjacent vertices of the dequeued vertex s.
			for (int n : adj[s]) {
				// If an adjacent has not been visited, then mark it visited & enqueue it.
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		// Taking input
		System.out.println("Enter number of vertices and edges");
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt();

		// invoking the class by making object
		Graph_Problem_02 g = new Graph_Problem_02(v);

		for(int i = 0; i < e; i++) {
			v = sc.nextInt();
			e = sc.nextInt();
			g.addEdge(v,  e);
		}

		sc.close();
		g.BFS(s);
	}
}
