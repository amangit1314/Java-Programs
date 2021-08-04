package backtracking;

public class MColoringProblem {

    // Number of vertices in the graph
    static int V = 4;

    // printing the solution
    static  void printSolution(int[] color){
        System.out.println("Solution Exists:" + "Following are the assigned colors ");
        for(int i = 0 ; i < V; i++){
            System.out.println(" " + color[i]);
        }
    }

    // checking if the move is safe or not
    static boolean isSafe(boolean[][] graph, int[] color){
        for(int i = 0; i < V; i++){
            for(int j = i+1; j < V; j++){
                if (graph[i][j] && color[j] == color[i])
                    return false;
            }
        }
        return true;
    }

    // function to color the graph
    static boolean graphColoring(boolean[][] graph, int m, int i, int[] color){
        // reach the last index
        if(i == V){
            if(isSafe(graph, color)){
                printSolution(color);
                return true;
            }
            return false;
        }

        for(int j = 1; j <= m; j++){
            color[i] = color[j];
            if(graphColoring(graph, m, i+1, color))
                return true;
            color[i] = 0;
        }
        return false;
    }

    // main function
    public static void main(String[] args) {

        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, false},
                {true, true, false, true},
                {true, false, true, false},
        };
        int m = 3; // Number of colors

        // Initialize all color values as 0.
        // This initialization is needed
        // correct functioning of isSafe()
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
        if (!graphColoring(graph, m, 0, color))
            System.out.println("Solution does not exist");
    }
}