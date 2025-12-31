package greedy;

// Chocola - Chocolate
public class Problem_29 {
    public static int minCostToBreakChocolate(int n, int m, int[] verticalCuts, int[] horizontalCuts) {
        java.util.Arrays.sort(verticalCuts);
        java.util.Arrays.sort(horizontalCuts);

        int vIndex = verticalCuts.length - 1;
        int hIndex = horizontalCuts.length - 1;

        int verticalSegments = 1;
        int horizontalSegments = 1;

        int totalCost = 0;

        while (vIndex >= 0 && hIndex >= 0) {
            if (verticalCuts[vIndex] > horizontalCuts[hIndex]) {
                totalCost += verticalCuts[vIndex] * horizontalSegments;
                verticalSegments++;
                vIndex--;
            } else {
                totalCost += horizontalCuts[hIndex] * verticalSegments;
                horizontalSegments++;
                hIndex--;
            }
        }

        while (vIndex >= 0) {
            totalCost += verticalCuts[vIndex] * horizontalSegments;
            vIndex--;
        }

        while (hIndex >= 0) {
            totalCost += horizontalCuts[hIndex] * verticalSegments;
            hIndex--;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 3; // number of rows
        int m = 3; // number of columns
        int[] verticalCuts = {2, 1}; // costs of vertical cuts
        int[] horizontalCuts = {1, 3}; // costs of horizontal cuts

        int result = minCostToBreakChocolate(n, m, verticalCuts, horizontalCuts);
        System.out.println("Minimum cost to break the chocolate: " + result);
    }
}
     