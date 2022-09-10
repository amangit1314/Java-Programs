package miscellaneous.aoa_lab;

import java.util.LinkedList;

public class BFS {
    private final int V;

    private final LinkedList<Integer>[] adj;

    // constructor
    BFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String[] args) {

    }
}