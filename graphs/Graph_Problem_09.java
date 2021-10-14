package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

// Problem Title =>  Clone a graph
/*
Approach =>
The idea is to do a BFS traversal of the graph and while visiting a node make a clone node of it (a copy of original node). If a node is encountered which is already visited then it already has a clone node.



How to keep track of the visited/cloned nodes?
A HashMap/Map is required in order to maintain all the nodes which have already been created.
Key stores: Reference/Address of original Node
Value stores: Reference/Address of cloned Node

A copy of all the graph nodes has been made, how to connect clone nodes?
While visiting the neighboring vertices of a node u get the corresponding cloned node for u , let’s call that cloneNodeU , now visit all the neighboring nodes for u and for each neighbor find the corresponding clone node(if not found create one) and then push into the neighboring vector of cloneNodeU node.

How to verify if the cloned graph is a correct?
Do a BFS traversal before and after the cloning of graph. In BFS traversal display the value of a node along with its address/reference.
Compare the order in which nodes are displayed, if the values are same but the address/reference is different for both the traversals than the cloned graph is correct.
 */

class GraphNode {
    int val;

    // A neighbour Vector which contains references to
    // all the neighbours of a GraphNode
    Vector<GraphNode> neighbours;
    public GraphNode(int val) {
        this.val = val;
        neighbours = new Vector<>();
    }
}

class CurrGraph {
    // A method which clones the graph and returns the reference of new cloned source node
    public GraphNode cloneGraph(GraphNode source) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(source);

        // An HashMap to keep track of all the nodes which have already been created
        HashMap<GraphNode,GraphNode> hm = new HashMap<>();

        //Put the node into the HashMap
        hm.put(source,new GraphNode(source.val));

        while (!q.isEmpty()) {
            // Get the front node from the queue and then visit all its neighbours
            GraphNode u = q.poll();

            // Get corresponding Cloned Graph Node
            GraphNode cloneNodeU = hm.get(u);
            if (u.neighbours != null) {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode graphNode : v) {
                    // Get the corresponding cloned node If the node is not cloned then we will simply get a null
                    GraphNode cloneNodeG = hm.get(graphNode);

                    // Check if this node has already been created
                    if (cloneNodeG == null) {
                        q.add(graphNode);

                        // If not then create a new Node and put into the HashMap
                        cloneNodeG = new GraphNode(graphNode.val);
                        hm.put(graphNode,cloneNodeG);
                    }

                    // add the 'cloneNodeG' to neighbour vector of the cloneNodeG
                    cloneNodeU.neighbours.add(cloneNodeG);
                }
            }
        }

        // Return the reference of cloned source Node
        return hm.get(source);
    }

    // Build the desired graph
    public GraphNode buildGraph() {
        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        Vector<GraphNode> v = new Vector<>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new Vector<>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new Vector<>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new Vector<>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    // BFS traversal of a graph to check if the cloned graph is correct
    public void bfs(GraphNode source) {
        Queue<GraphNode> q = new LinkedList<>();
        q.add(source);
        HashMap<GraphNode,Boolean> visit = new HashMap<>();
        visit.put(source,true);
        while (!q.isEmpty()) {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null) {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode g : v) {
                    if (visit.get(g) == null) {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }
}

public class Graph_Problem_09 {
    public static void main(String[] args) {
        CurrGraph graph = new CurrGraph();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        GraphNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}