package dp;
/*
* <-------------------------------------------------------------------------------------------------------------------->
* Problem Title :-  Maximum profit by buying and selling a share at most k times
*                   In share trading, a buyer buys shares and sells on a future date.
*  <------------------------------------------------------------------------------------------------------------------->
* Given :- the stock price of n days,
*          the trader is allowed to make at most k transactions,
*          where a new transaction can only start after the previous transaction is complete,
*  <------------------------------------------------------------------------------------------------------------------->
* Need To Do :- find out the maximum profit that a share trader could have made.
* <-------------------------------------------------------------------------------------------------------------------->
* */

public class DP_Problem_58{

    // Function to find out maximum profit by buying & selling a share at-most k times given stock price of n days
    static int maxProfit(int[] price, int n, int k){

        // table to store all the results of sub problems of super problem
        int[][] profit = new int[k + 1][n + 1];

        // For day 0, you can't earn money irrespective of how many times you trade
        for(int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any transaction (i.e. k =0)
        for(int j = 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in bottom-up fashion
        for(int i = 1; i <= k; i++){
            int prevDifference = Integer.MIN_VALUE;
            for(int j = 1; j < n; j++){
                prevDifference = Math.max(prevDifference, ( profit[i-1][j-1] - price[j-1] ));
                profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDifference);
            }
            return profit[k][n - 1];
        }
        return profit[k][n-1];
    }

    public static void main(String[] args) {
        int k = 3;
        int[] price = {2, 45, 87, 19, 75, 32, 15, 59};

        int n = price.length;

        System.out.println("Maximum profit is: " + maxProfit(price, n, k));
    }
}