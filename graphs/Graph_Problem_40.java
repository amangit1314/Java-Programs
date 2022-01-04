package graphs;
/*
  Problem Title => Vertex Cover Problem
  */

import java.util.*;

/**
 * ALGORITHM
 * 1) Initialize the result as {}
 * 2) Consider a set of all edges in given graph.  Let the set be E.
 * 3) Do following while E is not empty
 * -- (a) Pick an {arbitrary(apni marji se)} edge (u, v) from set E and add 'u' and 'v' to result
 * -- (b) Remove all edges from E which are either incident(event) on u or v.
 * 4) Return result
 * */

public class Graph_Problem_40 {

    private int V;

    // our given graph set
    private LinkedList<Integer>[] E;

    Graph_Problem_40(int v){
        V = v;
        E = new LinkedList[v];
        for(int i = 0; i < v; i++)
            E[i] = new LinkedList<>();

    }

    void addEdge(int v, int w){
        E[v].add(w);
        E[w].add(v);
    }

    void printVertexCover(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        Iterator<Integer> i;

        for(int u = 0; u < V; u++){
            if(!visited[u]){
                i = E[u].iterator();
                while (i.hasNext()){
                    int v = i.next();
                    if(!visited[v]){
                        visited[v] = true;
                        visited[u] = true;
                        break;
                    }
                }
            }
        }

        for(int j = 0; j < V; j++){
            if(visited[j])
                System.out.print(j+" ");
        }
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph_Problem_40 g = new Graph_Problem_40(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        g.printVertexCover();
    }
}