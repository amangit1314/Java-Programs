package arrays;

//? Problem Title :-> Best Time to buy and sell stocks [1]

// * You are allowed to buy and sell only once
// ! You are not allowed to sell first and then buy,
// ! (you must buy first and then sell)

public class Array_Problem_17 {

  public static int maxProfit(int[] prices) {
    int mini = prices[0];
    int maxProfit = 0;

    int n = prices.length;

    for(int i = 0; i < n; i++) {
      int cost = prices[i] - mini;
      maxProfit = Math.max(maxProfit, cost);
      mini = Math.min(mini, prices[i]);
    }

    return maxProfit;
  }

  	//Driver Method
	public static void main(String[] args) {
		int[] prices = {2, 7, 4, -5, 11, 5, 20};
		System.out.println("Max profit is -> " + maxProfit(prices));
	}
}
