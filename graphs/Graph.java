package graphs.practice;

import java.util.*;

public class Graph {
    private static int vertices;
    private static LinkedList<Integer>[] adjList;

    Graph(int vertex) {
        vertices = vertex;
        adjList = new LinkedList[vertex];
        for(int i = 0; i < vertex; ++i) {
            adjList[i] =  new LinkedList();
        }
    }

    public static void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public static void bfs(int source) {
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // Mark all as not visited
        boolean[] visited = new boolean[vertices];

        // Mark the current as true
        visited[source] = true;

        // add enqueue it
        queue.add(source);

        while(queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            source = queue.poll();
            System.out.println(source + " ");

            // Get all adjacent vertices of the dequeued vertex s,
            // If an adjacent has not been visited, then mark it visited and enqueue it
            for (int n : adjList[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);

        for(int n : adjList[vertex]) {
            while (!visited[n])
                dfsUtil(n, visited);
        }
    }

    public static void dfs(int source) {
        boolean[] vertex = new boolean[vertices];
        dfsUtil(source, vertex);
    }

    static void printGraph() {

        for(int i = 0; i < adjList[0].size(); i++) {

            System.out.println("\nAdjacency linkedList.list of vertex " + i);
            System.out.print("head");

            for(int j = 0; j < adjList[i].size(); j++)
                // for adjacency list
                //System.out.print(" -> " + adj.get(i).get(j));

                // for adjacency matrix
                System.out.print(" -> " + adjList[i].get(j));

            System.out.println();
        }
    }

    static boolean isCycle() {
        int[] in_degress = new int[vertices];
        Arrays.fill(in_degress, 0);

        for (int u = 0; u < vertices; u++) {
            for (int vertex : adjList[u])
                in_degress[vertex]++;
        }

        // Create a queue and enqueue all vertices with in degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
            if (in_degress[i] == 0)
                q.add(i);

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological ordering of the vertices)
        Vector<Integer> top_order = new Vector<>();

        // One by one dequeue vertices from queue and enqueue adjacent if in degree of adjacent becomes 0
        while (!q.isEmpty()) {

            // Extract front of queue (or perform dequeue) and add it to topological order
            int u = q.poll();
            top_order.add(u);

            // Iterate through all its neighbouring nodes of dequeued node u and decrease their in-degree by 1
            for (int itr : adjList[u])
                if (--in_degress[itr] == 0)
                    q.add(itr);
            cnt++;
        }

        // Check if there was a cycle
        return cnt != vertices;
    }

    static void mazeSearch() {

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);

        printGraph();
        System.out.println(isCycle());

        bfs(2);
        dfs(2);
    }
}