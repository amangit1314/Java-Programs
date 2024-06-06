package searchingSortingProblems;

import java.util.ArrayList;

//  Painter Partition
public class SSP_Problem_29 {
    private static int calculateSum(ArrayList<Integer> boards, int start, int end) {
        int totalSum = 0;
        for (int i = start; i <= end; i++) {
            totalSum = totalSum + boards.get(i);
        }
        return totalSum;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>(k + 1);

        for (int i = 0; i < k + 1; i++) {
            dp.add(new ArrayList<>(n + 1));
            for (int j = 0; j < n + 1; j++) {
                dp.get(i).add(0);
            }
        }

        for (int i = 1; i <= n; i++) {
            dp.get(i).set(i, calculateSum(boards, 0, i - 1));
        }

        for (int i = 1; i <= n; i++) {
            dp.get(i).set(1, boards.get(0));
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    best = Math.min(best, Math.max(dp.get(i - 1).get(p), calculateSum(boards, p, j - 1)));
                }

                dp.get(i).set(j, best);
            }
        }

        return dp.get(k).get(n);
    }
}
