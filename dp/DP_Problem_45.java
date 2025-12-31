// Weighted Job Scheduling to get the maximum profit

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class DP_Problem_45 {
    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start)
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int findMaxProfit(Job[] jobs, int n) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) {
                inclProf += dp[l];
            }
            dp[i] = Math.max(inclProf, dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(start, end, profit);
        }
        System.out.println("Maximum profit is: " + findMaxProfit(jobs, n));
        sc.close();
    }
}
       