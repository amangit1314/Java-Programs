package greedy;

// Min cost of ropes
public class Problem_32 {
    public static int minCostOfRopes(int[] ropes) {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int rope : ropes) {
            pq.offer(rope);
        }

        int totalCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6}; // lengths of ropes

        int result = minCostOfRopes(ropes);
        System.out.println("Minimum cost to connect all ropes: " + result);
    }
}