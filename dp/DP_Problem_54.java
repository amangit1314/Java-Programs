package dp;
import java.util.*;

/*
 * <-------------------------------------------------------------------------------------------------------------------->
 * Problem Title :-  Boolean Parenthesize.
 *  <------------------------------------------------------------------------------------------------------------------->
 * Given :- Given a boolean expression S of length N with following symbols.
            Symbols
                'T' ---> true
                'F' ---> false
            and following operators filled between symbols
            Operators
                &   ---> boolean AND
                |   ---> boolean OR
                ^   ---> boolean XOR
 *  <------------------------------------------------------------------------------------------------------------------->
 * Need To Do :- Count the number of ways we can parenthesize
 *               the expression so that the value of expression evaluates to true.
 * <-------------------------------------------------------------------------------------------------------------------->
 * */

public class DP_Problem_54 {

    static int countWays(int N, String S){
        // code here
        int[][][] dp = new int[N+1][N+1][2];
        for (int[][] ints : dp)
            for (int j = 0; j < dp[0].length; j++)
                Arrays.fill(ints[j], -1);

        return func(S, 0, S.length()-1, true, dp);
    }

    static int func(String str, int i, int j, boolean isTrue, int[][][] dp) {
        if(i > j)
            return 0;

        if(i == j){
            if(isTrue)
                return str.charAt(i)=='T'?1:0;

            else
                return (str.charAt(i)=='F')?1:0;
        }

        if(dp[i][j][isTrue ? 1 : 0] != -1)
            return dp[i][j][isTrue ? 1 : 0];

        int res = 0;
        for(int k = i + 1; k <= j - 1; k++) {
            int lt = func(str, i, k - 1, true, dp);
            int lf = func(str, i, k - 1, false, dp);
            int rt = func(str, k + 1, j, true, dp);
            int rf = func(str, k + 1, j, false, dp);
            char ch = str.charAt(k);

            if(ch == '&') {
                if(isTrue)
                    res += lt * rt;

                else
                    res += lf * rf + lf * rt + lt * rf;
            }

            else if(ch == '|') {
                if(isTrue)
                    res += lf * rt + lt * rf + lt * rt;

                else
                    res += lf * rf;
            }

            else if(ch == '^') {
                if(isTrue)
                    res += lf * rt + lt * rf;

                else
                    res += lf * rf + lt * rt;
            }
        }

        return dp[i][j][isTrue ? 1 : 0] = res % 1003;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.nextLine();
        System.out.println(countWays(N, S));
    }
}