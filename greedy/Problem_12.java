package greedy;

// Min cost to cut a board into squares

public class Problem_12 {
    static int minCostToCutBoard(int[] horizontalCuts, int[] verticalCuts) {
        java.util.Arrays.sort(horizontalCuts);
        java.util.Arrays.sort(verticalCuts);

        int h = horizontalCuts.length;
        int v = verticalCuts.length;

        int i = h - 1, j = v - 1;
        int horizontalSegments = 1, verticalSegments = 1;
        int totalCost = 0;

        while (i >= 0 && j >= 0) {
            if (horizontalCuts[i] > verticalCuts[j]) {
                totalCost += horizontalCuts[i] * verticalSegments;
                horizontalSegments++;
                i--;
            } else {
                totalCost += verticalCuts[j] * horizontalSegments;
                verticalSegments++;
                j--;
            }
        }

        while (i >= 0) {
            totalCost += horizontalCuts[i] * verticalSegments;
            i--;
        }

        while (j >= 0) {
            totalCost += verticalCuts[j] * horizontalSegments;
            j--;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] horizontalCuts = {2, 1, 3, 1, 4};
        int[] verticalCuts = {4, 1, 2};

        int result = minCostToCutBoard(horizontalCuts, verticalCuts);
        System.out.println("Minimum cost to cut the board into squares: " + result);
    }   
}