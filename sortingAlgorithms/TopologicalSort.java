package sortingAlgorithms;

import java.util.*;

// Problem Statement => Find a topological sequence of a directed acyclic graph.
public class TopologicalSort {

    // Vertices
    private final int V;

    // Adjacency List
    private final ArrayList<ArrayList<Integer> > adj;

    // Constructor
    TopologicalSort(int v){
        V = v;
        adj = new ArrayList<>(v);
        for(int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    // A recursive function to add an edge into the graph
    void topological_Order_Util(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        for (Integer integer : adj.get(v)) {
            i = integer;
            if (!visited[i])
                topological_Order_Util(i, visited, stack);
        }
        stack.push(v);
    }

    void topological_Order() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!visited[i])
                topological_Order_Util(i, visited, stack);

        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many number of edges you want to enter: ");
        int number = sc.nextInt();

        System.out.print("Enter the vertice name: ");
        int v = sc.nextInt();

        System.out.print("Enter weight of vertice: ");
        int w = sc.nextInt();

        TopologicalSort g = new TopologicalSort(v);

        for(int i = 0; i < number; i++)
            g.addEdge(v, w);

        System.out.println("Following is a Topological " + "sort of the given graph");
        sc.close();
        // Function Call
        g.topological_Order();
    }
}