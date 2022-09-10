package dp;

// Problem Title => Find if a string is interleaved of two other strings

/*Algorithm:

Create a DP arrays.array (matrix) of size M*N, where m is the size of the first string and n is the size of the second string. Initialize the matrix to false.
If the sum of sizes of smaller strings is not equal to the size of the larger string then return false and break the arrays.array as they can't be the interleaved to form the larger string.
Run a nested loop the outer loop from 0 to m and the inner loop from 0 to n. Loop counters are i and j.
If the values of i and j are both zeroes then mark dp[i][j] as true. If the value of i is zero and j is non-zero and the j-1 character of B is equal to j-1 character of C the assign dp[i][j] as dp[i][j-1] and similarly if j is 0 then match i-1 th character of C and A and if it matches then assign dp[i][j] as dp[i-1][j].
Take three characters x, y, z as (i-1)th character of A and (j-1)th character of B and (i + j – 1)th character of C.
if x matches with z and y does not match with z then assign dp[i][j] as dp[i-1][j] similarly if x is not equal to z and y is equal to z then assign dp[i][j] as dp[i][j-1]
if x is equal to y and y is equal to z then assign dp[i][j] as bitwise OR of dp[i][j-1] and dp[i-1][j].
return value of dp[m][n].*/
public class DP_Problem_59 {

    static boolean isInterleaved(String A, String B, String C){
        int M = A.length(), N = B.length();
        boolean[][] IL = new boolean[M+1][N+1];
        if((M + N) != C.length())   return false;

        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= N; j++){
                if(i == 0 && j == 0)    IL[i][j] = true;

                else if(i == 0){
                    if(B.charAt(j - 1) == C.charAt(j - 1))
                        IL[i][j] = IL[i][j-1];
                }

                else if(j == 0){
                    if(A.charAt(i - 1) == C.charAt(i - 1))
                        IL[i][j] = IL[i-1][j];
                }

                // Current character of C matches with current character of A, but doesn't match with current character if B
                else {
                    boolean b2 = A.charAt(i - 1) == C.charAt(i + j - 1);
                    boolean b = B.charAt(j - 1) != C.charAt(i + j - 1);
                    if (b2 && b)
                        IL[i][j] = IL[i - 1][j];

                    // Current character of C matches with current character of B, but doesn't match with current character if A
                    else {
                        if (b2 || b) {
                            if (b2 && B.charAt(j - 1) == C.charAt(i + j - 1))
                                IL[i][j] = (IL[i - 1][j] ||
                                        IL[i][j - 1]);
                        }

                        // Current character of C matches with that of both A and B
                        else {
                            IL[i][j] = IL[i][j - 1];
                        }
                    }
                }
            }
        }
        return IL[M][N];
    }

    // Function to run test cases
    static void test(String A, String B, String C) {
        if (isInterleaved(A, B, C))
            System.out.println(C + " is interleaved of " +
                    A + " and " + B);
        else
            System.out.println(C + " is not interleaved of " +
                    A + " and " + B);
    }

    // Driver code
    public static void main(String[] args) {
        test("XXY", "XXZ", "XXZXXXY");
        test("XY", "WZ", "WZXY");
        test("XY", "X", "XXY");
        test("YX", "X", "XXY");
        test("XXY", "XXZ", "XXXXZY");
    }
}