package greedy;

// Gerogovia - Wine trading in gergovia
public class Problem_27 {
    public static int minTotalDistance(int[] buyers, int[] sellers) {
        java.util.Arrays.sort(buyers);
        java.util.Arrays.sort(sellers);

        int totalDistance = 0;
        int i = 0, j = 0;
        int n = buyers.length;
        int m = sellers.length;

        while (i < n && j < m) {
            totalDistance += Math.abs(buyers[i] - sellers[j]);
            i++;
            j++;
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        int[] buyers = {1, 4, 6};
        int[] sellers = {2, 5, 8};

        int result = minTotalDistance(buyers, sellers);
        System.out.println("Minimum total distance: " + result);
    }
}
     