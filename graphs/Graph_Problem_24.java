package graphs;

// Problem Title => Graph Coloring
public class Graph_Problem_24 {

    // Function to check if the current color assignment is safe for vertex v
    static boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    // A recursive utility function to solve the m-coloring problem
    static boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        // Base case: If all vertices are assigned a color then return true
        if (v == graph.length) {
            return true;
        }

        // Consider this vertex v and try different colors
        for (int c = 1; c <= m; c++) {
            // Check if assignment of color c to v is fine
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                // Recur to assign colors to the rest of the vertices
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                // If assigning color c doesn't lead to a solution then remove it
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex then return false
        return false;
    }

    // This function solves the m-coloring problem using backtracking.
    // It mainly uses graphColoringUtil() to solve the problem.
    // It returns false if the m colors cannot be assigned, otherwise, it returns true
    // and prints the assignments of colors to all vertices.
    static boolean graphColoring(int[][] graph, int m) {
        // Initialize all color values as 0. This initialization is needed
        // to check the color of the vertex.
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = 0;
        }

        // Call graphColoringUtil() for vertex 0
        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(color);
        return true;
    }

    // A utility function to print the solution
    static void printSolution(int[] color) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < color.length; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        // Number of colors
        int m = 3; // Number of colors

        // Function call to solve the m-coloring problem
        graphColoring(graph, m);
    }
}

/*
Approach:
1. The problem is to assign colors to the vertices of a graph such that no two adjacent vertices have the same color.
2. This is solved using backtracking. We start with the first vertex and assign it a color. We then move to the next vertex and assign it a color that is different from its adjacent vertices.
3. If we are able to color all vertices without any conflicts, we have found a solution. If we encounter a conflict, we backtrack and try a different color for the previous vertex.

Notes:
- The graph is represented as an adjacency matrix.
- The function `isSafe` checks if it is safe to color a vertex with a given color.
- The function `graphColoringUtil` is a recursive function that tries to color the graph using backtracking.
- The function `graphColoring` initializes the color array and calls the utility function.
- The function `printSolution` prints the color assigned to each vertex.

Example:
Input:
Graph (Adjacency Matrix):
0 1 1 1
1 0 1 0
1 1 0 1
1 0 1 0

Number of colors: 3

Output:
Solution Exists: Following are the assigned colors
 1  2  3  2

Explanation:
- Vertex 0 is assigned color 1.
- Vertex 1 is assigned color 2.
- Vertex 2 is assigned color 3.
- Vertex 3 is assigned color 2.
- No two adjacent vertices have the same color.
*/