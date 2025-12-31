package greedy;

// Picking up chicks
public class Problem_28 {
    public static int maxChicksPicked(int[] chickPositions, int[] chickVelocities, int barnPosition, int timeLimit) {
        int n = chickPositions.length;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            int finalPosition = chickPositions[i] + chickVelocities[i] * timeLimit;
            if (finalPosition >= barnPosition) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] chickPositions = {0, 2, 5, 7};
        int[] chickVelocities = {1, 1, 1, 1};
        int barnPosition = 10;
        int timeLimit = 5;

        int result = maxChicksPicked(chickPositions, chickVelocities, barnPosition, timeLimit);
        System.out.println("Maximum chicks that can be picked: " + result);
    }
}
     