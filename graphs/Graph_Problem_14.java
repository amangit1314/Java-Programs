package graphs;
import java.util.*;

// Problem Title => Minimum time taken by each job to be completed given by a Directed Acyclic Graph
public class Graph_Problem_14 {
    static final int maxN = 100000;

    // Adjacency List to store the graph
    @SuppressWarnings("unchecked")
    static Vector<Integer> []graph = new Vector[maxN];

    // Array to store the in-degree of node
    static int[] indegree = new int[maxN];

    // Array to store the time in which the job i can be done
    static int []job = new int[maxN];

    // Function to add directed edge between two vertices
    static void addEdge(int u, int v) {

        // Insert edge from u to v
        graph[u].add(v);

        // Increasing the indegree of vertex v
        indegree[v]++;
    }

    // Function to find the minimum time needed by each node to get the task
    static void printOrder(int n, int m) {

        // Find the topological sort order using the indegree approach Queue to store the nodes while processing
        Queue<Integer> q = new LinkedList<>();

        // Pushing all the vertex in the queue whose in-degree is 0 Update the time of the jobs who don't require any job to be completed before this job
        for(int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                job[i] = 1;
            }
        }

        // Iterate until queue is empty
        while (!q.isEmpty()) {

            // Get front element of queue
            int cur = q.peek();

            // Pop the front element
            q.remove();

            for(int adj : graph[cur]) {

                // Decrease in-degree of the current node
                indegree[adj]--;

                // Push its adjacent elements
                if (indegree[adj] == 0){
                    job[adj] = 1 + job[cur];
                    q.add(adj);
                }
            }
        }

        // Print the time to complete
        // the job
        for(int i = 1; i <= n; i++)
            System.out.print(job[i] + " ");
        System.out.print("\n");
    }

    // Driver Code
    public static void main(String[] args) {
        // Given Nodes N and edges M
        int n, m;
        n = 10;
        m = 13;

        for(int i = 0; i < graph.length; i++)
            graph[i] = new Vector<Integer>();

        // Given directed edges of graph
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(2, 3);
        addEdge(2, 8);
        addEdge(2, 9);
        addEdge(3, 6);
        addEdge(4, 6);
        addEdge(4, 8);
        addEdge(5, 8);
        addEdge(6, 7);
        addEdge(7, 8);
        addEdge(8, 10);

        // Function call
        printOrder(n, m);
    }
}