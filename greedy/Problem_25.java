package greedy;

// DEFKIN - Defense of a kingdom

public class Problem_25 {
    public static int maxDefendedCities(int[] cityPositions, int k) {
        java.util.Arrays.sort(cityPositions);
        int defendedCities = 0;
        int i = 0;
        int n = cityPositions.length;

        while (i < n) {
            defendedCities++;
            int loc = cityPositions[i] + k;

            while (i < n && cityPositions[i] <= loc) {
                i++;
            }

            loc = cityPositions[i - 1] + k;

            while (i < n && cityPositions[i] <= loc) {
                i++;
            }
        }

        return defendedCities;
    }

    public static void main(String[] args) {
        int[] cityPositions = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2; // Defense range

        int result = maxDefendedCities(cityPositions, k);
        System.out.println("Maximum number of defended cities: " + result);
    }
}
     