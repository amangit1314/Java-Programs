package greedy;

// Buy max stocks if i stocks can be bought on i-th day

public class Problem_09 {
    public static int maxStocks(int[] prices) {
        int n = prices.length;
        int maxStocks = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxStocks += prices[i] - minPrice;
        }

        return maxStocks;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum stocks that can be bought: " + maxStocks(prices));
    }
}