package graphs;
import java.util.*;
// Problem Title :-> Create a Graph, print it using Linked List
public class Graph_Problem_01_ii {
	
	final LinkedList<Integer>[] adj;

	public Graph_Problem_01_ii(int v) {
		
		//arrays.array of Linked List
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++) 
			adj[i] = new LinkedList<>();
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);	
	}

	public static void main(String[] args) {
		
		System.out.println("Enter number of vertices and edges");
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph_Problem_01_ii graph_Problem_01_ii = new Graph_Problem_01_ii(v);
		
		System.out.println("Enter " + e + " edges");
		
		for(int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph_Problem_01_ii.addEdge(source,  destination);
		}
		
		sc.close();
	}
}
