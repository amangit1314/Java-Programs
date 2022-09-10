package arrays.aarrays;

public class Share_Selling_Atmost_Twice {

    static int maxProfit(int[] price, int n){
        int[] profit = new int[n];
        for(int i = 0; i < n; i++){
            profit[i] = 0;
        }

        int maxPrice = price[n-1];
        for(int i = n-2; i >= 0; i--){
            if(price[i] > maxPrice)
                maxPrice = price[i];
            profit[i] = Math.max(maxPrice - price[i], profit[i+1]);
        }

        int minPrice = price[0];
        for(int i = 1; i < n; i++){
            if(price[i] < minPrice){
                minPrice = price[i];
            }
            profit[i] = Math.max(profit[i-1], profit[i]+(price[i]-minPrice));
        }
        return profit[n-1];
    }

    public static void main(String[] args) {
        int[] price = {2, 30, 15, 10, 8, 25, 80};
        int n = price.length;
        System.out.println("Maximum Profit = " + maxProfit(price, n));
    }
}