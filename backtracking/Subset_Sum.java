package backtracking;

public class Subset_Sum {

    public static boolean isSubsetSum(int[] set, int n, int sum ){
        // base case 1
        if(sum >= 0 && n == 0)
            return false;

        // base case 2
        if(sum == 0)
            return true;

        if(set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

        return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
    }

    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset" + " with given sum");
        else
            System.out.println("No subset with" + " given sum");
    }
}