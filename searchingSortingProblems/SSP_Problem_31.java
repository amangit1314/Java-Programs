package searchingSortingProblems;

// SPOJ Roti prata
public class SSP_Problem_31 {

    public static int minTime(int[] ranks, int p) {
        // int n = ranks.length; // Number of chefs
        int minRank = Integer.MAX_VALUE;
        int sumRanks = 0;

        // Find the minimum rank and sum of ranks for all chefs
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            sumRanks += rank;
        }

        int low = minRank; // Minimum possible time (minimum chef rank)
        int high = sumRanks; // Maximum possible time (sum of all chef ranks for 1 prata)
        while (low <= high) {
            int midTime = (low + high) / 2;
            int totalCooked = 0;

            // Check if all pratas can be cooked in midTime
            for (int rank : ranks) {
                int numPratas = 0;
                int time = midTime;
                while (time > 0) {
                    numPratas++;
                    time -= rank * numPratas;
                }
                totalCooked += numPratas;
            }

            if (totalCooked < p) {
                low = midTime + 1; // Not enough pratas cooked, need more time
            } else {
                high = midTime; // Enough pratas cooked, might be too fast
            }
        }

        return low; // Minimum time required to cook all pratas
    }

    public static void main(String[] args) {
        int[] ranks = { 2, 3, 4 };
        int p = 10;

        int minTime = minTime(ranks, p);
        System.out.println("Minimum time to cook all pratas: " + minTime);
    }

}
