package graphs;

import java.util.*;

/* NOTE:
    - Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures.
    - BFS make use of Queue data structure to keep track of path.
    - And it requires a boolean array for maintaining visitid nodes.
*/

/* STEPS: 
    - Mark all the vertices as false (by default)
    - Create a queue
    - Mark current node true(to represent visited) and add it to queue(enqueue)
    - While queue is not empty
    - Delete from queue(Dequeue) and store it in source.
    - For each node(vertex) in graph
        . if an adjacent is not visited
        . visit that adjacent node and add it to queue  
 */

public class BFS {

    public static Queue<Integer> breadthFirstSearch(int[][] adj, int source, int totalNodes) {
        boolean[] visited = new boolean[totalNodes];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();

            for (int num : adj[source]) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        int[][] adj = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        Queue<Integer> bfsTraversal = breadthFirstSearch(adj, 4, adj.length);

        System.out.println("Breadth First Search Traversal: " + bfsTraversal);
    }
}