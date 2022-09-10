package graphs;
import java.util.*;

public class KosaRaju_Algorithm {
  // No. of vertices
  private final int V;

  // Adjacency List
  private final LinkedList<Integer>[] adj;

  // Constructor
  KosaRaju_Algorithm(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<>();
  }

  //Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // A recursive function to print DFS starting from v
  private void DFSUtil(int v, boolean[] visited) {
    // Mark the current node as visited and print it
    visited[v] = true;
    System.out.print(v + " ");

    int n;

    // Recur for all the vertices adjacent to this vertex
    for (Integer integer : adj[v]) {
      n = integer;
      if (!visited[n]) DFSUtil(n, visited);
    }
  }

  // Function that returns reverse (or transpose) of this graph
  KosaRaju_Algorithm getTranspose() {
    KosaRaju_Algorithm g = new KosaRaju_Algorithm(V);
    for (int v = 0; v < V; v++) {
      // Recursion for all the vertices adjacent to this vertex
      for (Integer integer : adj[v]) g.adj[integer].add(v);
    }
    return g;
  }

  // Function that fills the order
  void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
    // Mark the current node as visited and print it
    visited[v] = true;

    // Recur for all the vertices adjacent to this vertex
    for (int n : adj[v]) {
      if (!visited[n])
        fillOrder(n, visited, stack);
    }

    // All vertices reachable from v are processed by now, push v to Stack
    stack.push(v);
  }

  // The main function that finds and prints all strongly connected components
  void printSCCs() {
    Stack<Integer> stack = new Stack<>();

    // Mark all the vertices as not visited (For first DFS)
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) visited[i] = false;

    // Fill vertices in stack according to their finishing times
    for (int i = 0; i < V; i++)
      if (!visited[i])
        fillOrder(i, visited, stack);

    // Create a reversed graph
    KosaRaju_Algorithm gr = getTranspose();

    // Mark all the vertices as not visited (For second DFS)
    for (int i = 0; i < V; i++) visited[i] = false;

    // Now process all vertices in order defined by Stack
    while (!stack.empty()) {

      // Pop a vertex from stack
      int v = stack.pop();

      // Print Strongly connected component of the popped vertex
      if (!visited[v]) {
        DFSUtil(v, visited);
        System.out.println();
      }
    }
  }

  // Driver method
  public static void main(String[] args) {
    // Create a graph given in the above diagram
    KosaRaju_Algorithm g = new KosaRaju_Algorithm(5);
    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(3, 4);

    System.out.println("Following are strongly connected components " + "in given graph ");
    g.printSCCs();
  }
}

/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(V + E)
| Auxiliary Space ->  | O(n)
<---------------------------------------------------------------------------------------------------------------------->
 */
