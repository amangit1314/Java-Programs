package greedy;

// Find the min and max amount to buy all n candies

public class Problem_10 {
    public static int[] minMaxCandyCost(int[] prices, int n) {
        // Sort prices in ascending order for minimum cost
        java.util.Arrays.sort(prices);
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += prices[i];
        }

        // Sort prices in descending order for maximum cost
        java.util.Arrays.sort(prices);
        int maxCost = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxCost += prices[i];
        }

        return new int[]{minCost, maxCost};
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4, 5};
        int n = prices.length;
        int[] result = minMaxCandyCost(prices, n);
        System.out.println("Minimum cost to buy all candies: " + result[0]);
        System.out.println("Maximum cost to buy all candies: " + result[1]);
    }
}