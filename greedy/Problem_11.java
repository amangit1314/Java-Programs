package greedy;

// Minimize cash flow among a given set of frineds who have borrowed money from each other

public class Problem_11 {
    static final int N = 3;

    // Function to get the index of the minimum value in an array
    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    // Function to get the index of the maximum value in an array
    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    // Function to minimize cash flow among friends
    static void minimizeCashFlow(int amount[]) {
        int mxCredit = getMax(amount);
        int mxDebit = getMin(amount);

        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        int min = Math.min(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        System.out.println("Person " + mxDebit + " pays " + min + " to Person " + mxCredit);

        minimizeCashFlow(amount);
    }

    public static void main(String[] args) {
        int amount[] = {0, -7000, 3000};

        minimizeCashFlow(amount);
    }
}