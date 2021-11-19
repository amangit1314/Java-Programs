package dp;
// Problem Title => Friends Pairing Problem
public class DP_Problem_09 {

    static int countFriendsPairings(int n){
        int[] dp = new int[n + 1];
        // filling dp[] in bottom-up manner using recursive formula.
        for(int i = 0; i < n; i++){
            if(i <= 2) dp[i] = i;
            else
                dp[i] = dp[i-1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countFriendsPairings(n));
    }
}