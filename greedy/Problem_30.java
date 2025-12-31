package greedy;

// Arrange - Arranging Amplifiers
public class Problem_30 {
    public static int minCostToArrangeAmplifiers(int[] costs) {
        java.util.Arrays.sort(costs);

        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            totalCost += costs[i] * (i + 1);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] costs = {4, 2, 1, 3}; // costs of amplifiers

        int result = minCostToArrangeAmplifiers(costs);
        System.out.println("Minimum cost to arrange the amplifiers: " + result);
    }
}
     