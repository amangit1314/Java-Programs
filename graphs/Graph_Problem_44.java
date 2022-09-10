package graphs;
import java.util.*;
import java.util.Deque;

// Problem Title => Two Clique Problem
/*
* Two Clique Problem (Check if Graph can be divided in two Cliques)
Difficulty Level : Hard
Last Updated : 20 Aug, 2021
A Clique is a subgraph of graph such that all vertices in subgraph are completely connected with each other. Given a Graph, find if it can be divided into two Cliques.

Examples:

Attention reader! Don’t stop learning now. Get hold of all the important DSA concepts with the DSA Self Paced Course at a student-friendly price and become industry ready.  To complete your preparation from learning a language to DS Algo and many more,  please refer Complete Interview Preparation Course.

In case you wish to attend live classes with experts, please refer DSA Live Classes for Working Professionals and Competitive Programming Live for Students.

Input : G[][] =   {{0, 1, 1, 0, 0},
                  {1, 0, 1, 1, 0},
                  {1, 1, 0, 0, 0},
                  {0, 1, 0, 0, 1},
                  {0, 0, 0, 1, 0}};
Output : Yes




Recommended: Please try your approach on {IDE} first, before moving on to the solution.
This problem looks tricky at first, but has a simple and interesting solution. A graph can be divided in two cliques if its complement graph is Bipartitie. So below are two steps to find if graph can be divided in two Cliques or not.

Find the complement of Graph. Below is the complement graph is above shown graph. In complement, all original edges are removed. And the vertices which did not have an edge between them, now have an edge connecting them.
twoclique2

Return true if complement is Bipartite, else false. The above shown graph is Bipartite. Checking whether a Graph is Biparitite or no is discussed here.
How does this work?
If complement is Bipartite, then graph can be divided into two sets U and V such that there is no edge connecting to vertices of same set. This means in original graph, these sets U and V are completely connected. Hence original graph could be divided in two Cliques.
 * */
public class Graph_Problem_44 {

    static int V = 5;

    // This function returns true if subgraph reachable from
// src is Bipartite or not.
    static boolean isBipartiteUtil(int G[][], int src, int colorArr[])
    {
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and enqueue
        // source vertex for BFS traversal
        Deque <Integer> q = new ArrayDeque<>();
        q.push(src);

        // Run while there are vertices in queue (Similar to BFS)
        while (!q.isEmpty())
        {
            // Dequeue a vertex from queue
            int u = q.peek();
            q.pop();

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v)
            {
                // An edge from u to v exists and destination
                // v is not colored
                if (G[u][v] == -1 && colorArr[v] == -1)
                {
                    // Assign alternate color to this adjacent
                    // v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and destination
                // v is colored with same color as u
                else if (G[u][v] == colorArr[u] && colorArr[v] == colorArr[u])
                    return false;
            }
        }

        // If we reach here, then all adjacent vertices can
        // be colored with alternate color
        return true;
    }

    // Returns true if a Graph G[][] is Bipartite or not. Note
// that G may not be connected.
    static boolean isBipartite(int G[][])
    {
        // Create a color arrays.array to store colors assigned
        // to all vertices. Vertex number is used as index in
        // this arrays.array. The value '-1' of  colorArr[i]
        // is used to indicate that no color is assigned to
        // vertex 'i'.  The value 1 is used to indicate first
        // color is assigned and value 0 indicates
        // second color is assigned.
        int colorArr[]=new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // One by one check all not yet colored vertices.
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr) == false)
                    return false;

        return true;
    }

    // Returns true if G can be divided into
// two Cliques, else false.
    static boolean canBeDividedinTwoCliques(int G[][])
    {
        // Find complement of G[][]
        // All values are complemented except
        // diagonal ones
        int GC[][]=new int[V][V];
        for (int i=0; i<V; i++)
            for (int j=0; j<V; j++)
                GC[i][j] = (i != j)?  -GC[i][j] : 0;

        // Return true if complement is Bipartite
        // else false.
        return  isBipartite(GC);
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[][] G = {{0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0}
        };

        if(canBeDividedinTwoCliques(G))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}