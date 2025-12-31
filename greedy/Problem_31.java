package greedy;

// K Centers Problem
public class Problem_31 {
    public static int minDistanceToKCenters(int[] points, int k) {
        java.util.Arrays.sort(points);

        int n = points.length;
        if (k >= n) {
            return 0; // Each point can be its own center
        }

        int left = 0;
        int right = points[n - 1] - points[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canPlaceCenters(points, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canPlaceCenters(int[] points, int k, int distance) {
        int count = 1; // Place the first center at the first point
        int lastCenter = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i] - lastCenter > distance) {
                count++;
                lastCenter = points[i];
                if (count > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] points = {1, 2, 8, 4, 9}; // positions of points
        int k = 3; // number of centers

        int result = minDistanceToKCenters(points, k);
        System.out.println("Minimum distance to place " + k + " centers: " + result);
    }
}
     