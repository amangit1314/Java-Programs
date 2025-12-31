package greedy;

// Max trains for which stoppage can be provided

public class Problem_07 {
    public static int maxStopTrains(int[] arrival, int[] departure) {
        int n = arrival.length;

        // Sort trains by their departure times
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (departure[j] > departure[j + 1]) {
                    // Swap departure times
                    int tempDep = departure[j];
                    departure[j] = departure[j + 1];
                    departure[j + 1] = tempDep;

                    // Swap corresponding arrival times
                    int tempArr = arrival[j];
                    arrival[j] = arrival[j + 1];
                    arrival[j + 1] = tempArr;
                }
            }
        }

        int count = 1; // At least one train can be stopped
        int lastDeparture = departure[0];

        for (int i = 1; i < n; i++) {
            if (arrival[i] >= lastDeparture) {
                count++;
                lastDeparture = departure[i];
            }
        }

        return count;
    }
}