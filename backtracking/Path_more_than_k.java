package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Path_more_than_k {

    static class AdjListNode {
        int v;
        int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {return v;}
    }

    static class Graph {
        int v;
        ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>();
        Graph(int v) {
            this.v = v;
            adj = new ArrayList<>();
            for(int i = 0; i < v; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v, int w) {
            AdjListNode n1 = new AdjListNode(v, w);
            adj.get(u).add(n1);
            AdjListNode n2 = new AdjListNode(u, w);
            adj.get(v).add(n2);
        }

        boolean pathMoreThanK(int sre, int k) {
            boolean[] path = new boolean[v];
            Arrays.fill(path, false);
            path[sre] = true;
            return  pathMoreThanKUtil(sre,k, path);
        }

        boolean pathMoreThanKUtil(int src, int k, boolean[] path) {
            if(k <= 0)
                return true;

            ArrayList<AdjListNode> it = adj.get(src);
            int index = 0;

            for(int i = 0; i < adj.get(src).size(); i++) {
                AdjListNode vertex = adj.get(src).get(i);
                int v = vertex.v;
                int w = vertex.weight;
                index++;

                if(path[v])
                    continue;

                if (w >= k)
                    return true;

                path[v] = true;

                if(pathMoreThanKUtil(v, k-w, path))
                    return true;

                path[v] = false;
            }
            return  false;
        }
    }

    public static void main(String[] args) {
        int v = 1;
        Graph g = new Graph(v);
    }
}