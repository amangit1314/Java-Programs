package graphs;
import java.util.*;

/*
 * Problem Title :-> Implement BFS Algorithm of Traversal of Graph.
 */
public class Graph_Problem_02 {
	// No. of vertices.
	private int V;
	// Adjacency List
	private LinkedList<Integer>[] adj;
	
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
		// Mark all the verices as not visited(By Default set as false)
		boolean visited[] = new boolean[V];
		
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			// Dequeue a vertex from queue and print
			s = queue.poll();
			System.out.println(s + " ");
			
			// Get all adjacent vertices of the dequeued vertex s.
			// If a adjacent has not been visited,
			// then mark it visited & enqueue it.
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter number of vertices and edges");
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph_Problem_02 g = new Graph_Problem_02(v);
		
		for(int i = 0; i < e; i++) {
			v = sc.nextInt();
			e = sc.nextInt();
			g.addEdge(v,  e);
		}
		
		sc.close();
	}
}
