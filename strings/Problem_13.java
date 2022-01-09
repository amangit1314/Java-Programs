package strings;
// Problem Title => Word Wrap Problem [Imp]
public class Problem_13 {

    static void solveWordWrap(int[] a, int n, int k){
        int i, j;
        int curr_len;
        int cost;
        int[] dp = new int[n];
        int[] ans = new int[n];
        dp[n-1] = 0;
        ans[n - 1] = n - 1;

        for(i = n - 2; i >= 0; i--){
            curr_len = -1;
            dp[i] = Integer.MAX_VALUE;

            // Keep on adding words in
            // current line by iterating
            // from starting word up to
            // last word in arr.
            for (j = i; j < n; j++) {

                // Update number of characters
                // in current line. arr[j] is
                // number of characters in
                // current word and 1
                // represents space character
                // between two words.
                curr_len += (a[j] + 1);

                // If limit of characters
                // is violated then no more
                // words can be added to
                // current line.
                if (curr_len > k)
                    break;

                // If current word that is
                // added to line is last
                // word of arr then current
                // line is last line. Cost of
                // last line is 0. Else cost
                // is square of extra spaces
                // plus cost of putting line
                // breaks in rest of words
                // from j+1 to n-1.
                if (j == n - 1)
                    cost = 0;
                else
                    cost = (k - curr_len) *
                            (k - curr_len) +
                            dp[j + 1];

                // Check if this arrangement gives minimum cost for line starting with word arr[i].
                if (cost < dp[i]) {
                    dp[i] = cost;
                    ans[i] = j;
                }
            }
        }

        // Print starting index and ending index of words present in each line.
        i = 0;
        while (i < n) {
            System.out.print((i + 1) + " " + (ans[i] + 1) + " ");
            i = ans[i] + 1;
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 2, 2, 5};
        int n = a.length;
        int M = 6;
        solveWordWrap(a, n, M);
    }
}