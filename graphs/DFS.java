package graphs;
import java.util.*;

/* Approach:
    Depth-first search is an algorithm for traversing or searching tree or graph data structures.
    The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.
    So the basic idea is to start from the root or any arbitrary node and mark the node and move to the adjacent unmarked node and continue this loop until there is no unmarked adjacent node.
    Then backtrack and check for other unmarked nodes and traverse them.
    Finally, print the nodes in the path.
 */

/*Algorithm:
    1. Create a recursive function that takes the index of the node and a visited arrays.array.
    2. Mark the current node as visited and print the node.
    3. Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the adjacent node.
*/

public class DFS {
    private int V;
    private LinkedList<Integer> adj[];

    DFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v){
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
        g.DFS(2);
    }
}