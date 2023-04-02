package greedy;

// Min number of coins [Greedy + DP]

// Variant 1 - Min Elements(CodeStudio)
// Variant 2 - Min no of coins to make a target
// Variant 1 - Min no of coins to make a amount

// Amazon + Adobe

public class Problem_06 {
    public static int solve(int ind, int[] arr, int x, int[][] dp){
        if(ind == 0){
            if(x % arr[0]==0)
                return x/arr[0];
            else return 1000000000+7;
        }

        if(dp[ind][x] != -1)
            return dp[ind][x];

        int notTake = solve(ind - 1, arr, x, dp);
        int take = Integer.MAX_VALUE;

        if(arr[ind] <= x){
            take = 1 + solve(ind, arr, x - arr[ind], dp);
        }

        return dp[ind][x] = Math.min(take, notTake);
    }

//    public static int minimumElements(int[] num, int x) {
//         //Write your code here.. //
//         int n = num.length;
//         int[][] dp = new int[n][x+1];
//
//         for(int i = 0; i < n; i++)
//             for(int j = 0; j < x + 1; j++)
//                 dp[i][j] = -1;
//
//         int ans = solve(n - 1, num, x, dp);
//         if(ans >= 1000000000 + 7)
//             return -1;
//
//         return ans;
//
//         for(int T = 0; T <= x; T++){
//             if( T % num[0] == 0)
//                 dp[0][T] = T / num[0];
//
//             else dp[0][T] = 1000000000+7;
//         }
//
//         for(int ind = 1; ind < n; ind++){
//             for(int T = 0; T <= x; T++){
//                 int notTake = 0 + dp[ind-1][T];
//                 int take = Integer.MAX_VALUE;
//                 if(num[ind] <= T){
//                    take = 1 + dp[ind][T-num[ind]];
//                 }
//                 dp[ind][T] = Math.min(take,notTake);
//             }
//         }
//
//         if(ans >= 1000000000 + 7)
//             return -1;
//         return ans;
//        }
//
}