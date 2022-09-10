package graphs;
// Problem Title => Travelling Salesman Problem implementation using BackTracking
public class Graph_Problem_23 {

    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans){
        if(count == n && graph[currPos][0] > 0){
            return Math.min(ans, cost + graph[currPos][0]);
        }

        for(int i = 0; i < n; i++){
            if(!v[i] && graph[currPos][i] > 0) {
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);
                v[i] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // n is the number of nodes i.e. V
        int n = 4;

        int[][] graph = {{90, 19, 51, 2},
                {40, 10, 53, 15},
                {85, 5, 0, 43},
                {92, 65, 13, 70}};

        // Boolean arrays.array to check if a node has been visited or not
        boolean[] v = new boolean[n];

        // Mark 0th node as visited
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans);

        // answer is the minimum weight Hamiltonian Cycle
        System.out.println(ans);
    }
}