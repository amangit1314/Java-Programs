package graphs;

import java.util.*;

public class ImportantGraphAlgos {

    private final int vertex;
    private static int p[], rank[];
    final ArrayList<ArrayList<Integer> > adj;

    public ImportantGraphAlgos(int v) {
        vertex = v;

        // an arraylist of arraylist
        adj = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>(v));
        }
    }

    void addEdge(int vertex, int edge) {
      adj.get(vertex).add(edge);
    }

    void dfsTraversal(int vertex) {

        ///* ALGORITHM
        //? 0 -> Define a Stack of size total number of vertices in graph.
        //? 1 -> Select any starting vertex. visit the vertex and push it to stack
        //? 2 -> visit the unvisited neighbour vertex of selected one and push it onto stack.
        //? 3 -> Repeat step 2 until there are no new vertices remained to visit from top of stack.
        //? 4 -> when there is no vertex to visit, then BACKTRACK & pop one vertex from stack.
        //? 5 -> repeat steps 2, 3, 4 until stack is empty

        // visited boolean array to keep track of visited and unvisited vertices
        boolean[] visited = new boolean[vertex];

        dfsUtil(vertex, visited);
    }

    void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int n : adj.get(vertex)) {
            if (!visited[n])
                dfsUtil(n, visited);
        }
    }
        
    void bfsTraversal(int selected) {
        //* visited boolean array to keep track of visited and unvisited vertices
        boolean[] visited = new boolean[vertex];

        ///* ALGORITHM
        //? 0 -> Define a Queue of size total number of vertices in graph.
        LinkedList<Integer> queue = new LinkedList<>();

        //? 1 -> Select any starting vertex. visit the vertex and insert into queue
        visited[selected] = true;
        queue.add(selected);

        while(queue.size() != 0) {
            selected = queue.poll();
            System.out.print(selected + " ");

            //? 2 -> visit all the adjacent unvisited vertices of the vertex which is at front of queue & insert them into the queue.
            for(int n : adj.get(selected)) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
            //? 3 -> when there is no vertex to visit from the vertex at front of queue., insert them into queue
        }
        //? 4 -> repeat steps 2, 3, until queue becomes empty
    }     

    // <------------------------------------------- For Prims Algorithm -------------------------------------------->

    int minKey(int[] key, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for(int v = 0; v < vertex; v++) {
            if(!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printMST(int[] minSpanTree, ArrayList<ArrayList<Integer>> adj) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertex; i++)
            System.out.println(minSpanTree[i] + " - " + i + "\t" + adj.get(i).get(minSpanTree[i]));
    }

    void primsAlgorithm(int selected, ArrayList<ArrayList<Integer>> adj) {
        //? 1 -> Select any starting vertex. visit the vertex and insert into queue
        boolean[] visited = new boolean[vertex];
       // visited[selected] = true;

        // Queue for min spanning tree
        //LinkedList<Integer> queue = new LinkedList<>();
        //queue.add(selected);

        // constructed
        int[] minSpanTree = new int[vertex];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[vertex];

        // Initialize all keys as INFINITE
        for (int i = 0; i < vertex; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;
        //queue.add(key[0]);

        // Make key 0 so that this vertex is picked as first vertex
        // First node is always root of MST
        minSpanTree[0] = 0;

        // The MST will have V vertices
        for (int count = 0; count < vertex - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, visited);

            // Add the picked vertex to the MST Set
            visited[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            // Consider only those vertices which are not yet included in MST
            for (int v = 0; v < vertex; v++) {
                // adj.get(u).get(v) is non-zero only for adjacent vertices of m
                // Where visited[v] is false for vertices not yet included in MST.
                // Update the key only if adj.get(u).get(v) is smaller than key[v]
                if (adj.get(u).get(v) != 0 && !visited[v] && adj.get(u).get(v) < key[v]) {
                    minSpanTree[v] = u;
                    //queue.add(u);
                    key[v] = adj.get(u).get(v);
                }
            }

            // print the constructed MST
            printMST(minSpanTree, adj);

            //? 2 -> Repeat steps 3 and 4 until there are fringe vertices.
            //? 3 -> Select an edge with minimum weight from the fringe vertices.

            //? 4 -> Add the selected edge and the vertex at the other end of the edge to the minimum spanning tree.
        }
    }
    // <----------------------------- Prims Ends Here -------------------------------------------------------------->

    // <------------------------------------------- For Kruskals Algorithm -------------------------------------------->
    class Edge implements Comparable<Edge> {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt - that.wt;
        }
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(rx == ry) return;
        p[ry] = rx;
    }

    static int find(int x){
        if(p[x] == x)
            return x;
        return find(p[x]);
    }

    int kruskalsAlgo(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
      ///* ALGORITHM
      //? Step 1 -> Create a Forest in such a way that each graph is separate tree.

      //? Step 2 -> Create a Priority Queue that contains all edges of graph.
    
      //? Step 3 -> Repeat step 4 and 5 until there are no edges in the Priority Queue.

      //? Step 4 -> Remove the edge with minimum weight from the Priority Queue.
      /* Step 5 -> IF -> edge obtained in Step 4 connects two diff trees,
                         THEN add it to the fores (for connecting two trees                             into one tree).
                  ELSE -> Discard the edge. */

        // here we will use union find method

        boolean[][] added = new boolean[vertex][vertex];
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                ArrayList<Integer> cur = adj.get(i).get(j);

                if(!added[i][cur.get(0)]) {
                    added[i][cur.get(0)] = true;
                    added[cur.get(0)][i] = true;
                    edges.add(new Edge(i, cur.get(0), cur.get(1)));
                }
            }
        }

        p = new int[vertex];
        for(int i = 0; i < vertex; i++) {
            p[i] = i;
        }

        Collections.sort(edges);
        int count = 1;
        int ans = 0;

        for(int i = 0; count < vertex; i++) {
            Edge edge = edges.get(i);
            int rx = find(edge.src);
            int ry = find(edge.dest);

            if(rx != ry){
                union(rx, ry);
                count++;
                ans += edge.wt;
            }
        }
        return ans;
    }
    // <----------------------------- Kruskals Ends Here -------------------------------------------------------------->

    // <----------------------------- Topological Sorting ------------------------------------------------------------>
    void topologicalSorting() {
      //! Note -> TOPOLOGICAL SORT => 
      //! Linear ordering of vertices such that for every edge u -> v is always appears before v in that ordering.
        // call dfs util function for all components
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertex];

        for(int i = 0; i < vertex; i++) {
          if(!visited[i])
              topologicalSortingUtil(i, visited, stack);
        }

        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    void topologicalSortingUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        int i;

        for (int integer = 0; integer < adj.get(vertex).get(vertex); integer++) {
            i = integer;
            if (!visited[i])
                topologicalSortingUtil(i, visited, stack);
        }
        stack.push(vertex);
    }
    // <----------------------------- Topological Sorting Ends here --------------------------------------------------->

    // <----------------------------- Dijkstras Algorithm ------------------------------------------------------------>
    void dijkstrasAlgo() {
        ///* ALGORITHM
        //? Step 1 -> Set vertices distance = infinity, except for source vertex. Set the source vertex distance = 0.

        //? Step 2 -> Push source vertex in the Min-Priority Queue in the form (distance, vertex),
        //?           as the comparison in the min-priority queue will be a/c to vertices distances.
    
        //? Step 3 -> Pop the vertex with minimum distance from the Priority Queue. (at first popped vertex = source)
    
        //? Step 4 -> Update the distance of the connected vertices to the popped vertex.
        //?           In case of "current.weight + edge.weight < (next vertex distance)", 
        //?           then push the vertex with the new distance to the priority queue.

        //? Step 5 -> If popped vertex is already visited just continue without using it.

        //? Step6 -> Apply the same algorithm for all the vertices in the Priority Queue until Priority Queue become empty.   
    }
    // <----------------------------- Dijkstras Algorithm ends  ------------------------------------------------------>

    //! <---------------------  KOSARAJU ALGORITHM -------------------------------------------------------------------->

    // Mainly used to find strongly connected components in the Graph

    //? Function that returns reverse (or transpose) of this graph
    ImportantGraphAlgos getTranspose() {
        ImportantGraphAlgos g = new ImportantGraphAlgos(vertex);
        for (int v = 0; v < vertex; v++) {
            // Recursion for all the vertices adjacent to this vertex
            for (Integer integer : adj.get(v))
                g.adj.get(integer).add(v);
        }
        return g;
    }

    //? Function that fills the order
    void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
    // Mark the current node as visited and print it
    visited[v] = true;

    // Recur for all the vertices adjacent to this vertex
    for (int n : adj.get(v)) {
      if (!visited[n])
        fillOrder(n, visited, stack);
    }

    // All vertices reachable from v are processed by now, push v to Stack
    stack.push(v);
    }

    //? The main function that finds and prints all strongly connected components
    void printSccsByKosarajuAlgorithm() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited (For first DFS)
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) visited[i] = false;

        // Fill vertices in stack according to their finishing times
        for (int i = 0; i < vertex; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < vertex; i++) visited[i] = false;
   
        // Now process all vertices in order defined by Stack
        while (!stack.empty()) {
            // Pop a vertex from stack
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                dfsUtil(v, visited);
                System.out.println();
            }
        }
    //! <---------------------------- KOSARAJU ALGORITHM END HERE ----------------------------->
  }
    // <----------------------------- Kosaraju Algorithm  ------------------------------------------------------------>
    public static void main(String[] args) {
    ImportantGraphAlgos g = new ImportantGraphAlgos(5);
    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(3, 4);

    System.out.println("Following are strongly connected components " + "in given graph ");
    g.printSccsByKosarajuAlgorithm();
    g.primsAlgorithm(0, g.adj);
    g.bfsTraversal(0);
  }
}