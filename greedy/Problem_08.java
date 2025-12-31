package greedy;

// Min platforms problem

public class Problem_08 {
    public static int findMinPlatforms(int[] arrival, int[] departure) {
        int n = arrival.length;
        int[] platformNeeded = new int[2400]; // Assuming time is in HHMM format

        // Increment platform count for each arrival
        for (int time : arrival) {
            platformNeeded[time]++;
        }

        // Decrement platform count for each departure
        for (int time : departure) {
            platformNeeded[time]--;
        }

        int maxPlatforms = 0;
        int currentPlatforms = 0;

        // Calculate the maximum platforms needed at any time
        for (int i = 0; i < platformNeeded.length; i++) {
            currentPlatforms += platformNeeded[i];
            if (currentPlatforms > maxPlatforms) {
                maxPlatforms = currentPlatforms;
            }
        }

        return maxPlatforms;
    }
}