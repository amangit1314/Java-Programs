package dp;
// Problem Title => Maximum Length of Pair Chain
// Note - LIS PAttern
public class DP_Problem_60 {
    int a, b;

    public DP_Problem_60(int a, int b){
        this.a = a;
        this.b = b;
    }

    // This function assumes that arr[] is sorted in increasing order according the first(or smaller) values in pairs.
    static void maxChainLength(DP_Problem_60[] arr, int n){

    }

    static void solve(DP_Problem_60[] arr, int n) {

    }

    static void solveMem(DP_Problem_60[] arr, int n) {

    }

    // Recursion + Tabulation (Bottom Up DP)
    static void solveTab(DP_Problem_60[] arr, int n) {

    }

    // space optimized code if possible
    static int solveTabSo(DP_Problem_60[] arr, int n) {
        int i, j, max = 0;
        int[] mcl = new int[n];

        // Initialize MCL(maximum chain length) values for all indexes
        for(i = 0; i < n; i++)
            mcl[i] = 1;

        // Compute optimized chain length values in bottom up manner
        for(i = 1; i < n; i++)
            for(j = 0; j < i; j++)
                if(arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1)
                    mcl[i] = mcl[j] = 1;

        // mcl[i] now stores the maximum chain length ending with pair i. Pick maximum of all MCL values.
        for(i = 0; i < n; i++)
            if(max < mcl[i])
                max = mcl[i];

        return max;
    }

    // Driver function
    public static void main(String[] args) {
        DP_Problem_60[] arr = new DP_Problem_60[]{
                new DP_Problem_60(5, 24),
                new DP_Problem_60(15, 25),
                new DP_Problem_60(27, 40),
                new DP_Problem_60(50, 60),
        };
//        System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));
    }
}

