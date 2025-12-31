package greedy;

// Program for shortest job first (or SJF) Cpu scheduling

public class Problem_21 {
    static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    static void findAvgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n];
        int tat[] = new int[n];

        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);

        System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time");

        int total_wt = 0, total_tat = 0;
        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println(" " + (i + 1) + "\t\t" + bt[i] + "\t " + wt[i] + "\t\t " + tat[i]);
        }

        System.out.println("Average waiting time = " + (float) total_wt / (float) n);
        System.out.println("Average turn around time = " + (float) total_tat / (float) n);
    }

    public static void main(String args[]) {
        int processes[] = {1, 2, 3};
        int n = processes.length;

        int burst_time[] = {6, 8, 7};

        findAvgTime(processes, n, burst_time);
    }
}
