package graphs;
/*
*
* Problem Title => Minimize Cash Flow among a given set of friends who have borrowed money from each other
* Difficulty Level : Hard
* Given a number of friends who have to give or take some amount of money from one another.
* Design an algorithm by which the total cash flow among all the friends is minimized.
*
* */
public class Graph_Problem_43 {

    // Number of persons (or vertices in the graph)
    static int N = 3;

    // A utility function that returns index of minimum value in arr[]
    static int getMin(int[] arr){
        int minInd = 0;
        for(int i = 1; i < N; i++)
            if(arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    // A utility function that returns index of maximum value in arr[]
    static int getMax(int[] arr){
        int maxInd = 0;
        for(int i = 1; i < N; i++)
            if(arr[i] < arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    // A utility function to return minimum of 2 values
    static int minOf2(int x, int y){
        return (x < y) ? x : y;
    }

    // amount[p] indicates the net amount to be credited/ debited to/from person 'p'.
    // If amount[p] is positive, then i'th person will amount[i].
    // If amount[p] is negative, them i'th person will give -amount[i]
    static void minCashFlowRec(int[] amount){
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        // If both amounts are 0, then all amounts are settled
        if(amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        // finding minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        System.out.println("Person " + mxDebit + " pays " + min + " to " + "Person " + mxCredit);
        minCashFlowRec(amount);
    }

    // amount[p] indicates the net amount to be credited/debited to/from person 'p'.
    // If amount[p] is positive, then i'th person will amount[i].
    // If amount[p] is negative, then i'th person will give -amount[i].
    static void minCashFlow(int[][] graph){
        // Create an arrays.array amount[], initialize all value in it as 0.
        int[] amount = new int[N];
        // Calculate the net amount to be paid to person 'p', and stores it in amount[p].
        // The value of amount[p] can be calculated by subtracting debts of 'p' from credits of 'p'.
        for(int p = 0; p < N; p++){
            for(int i = 0; i < N; i++)
                amount[p] += (graph[i][p] - graph[p][i]);
        }
        minCashFlowRec(amount);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}
        };
        // here's the solution 😍
        minCashFlow(graph);
    }
}