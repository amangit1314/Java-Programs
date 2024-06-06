package searchingSortingProblems;

public class SSP_Problem_26 {
    public static int minCuttingHeight(int[] treeHeights, int n, int m) {
        int maxh = Integer.MIN_VALUE; // Find the maximum height of any tree
        for (int h : treeHeights) {
            maxh = Math.max(maxh, h);
        }

        int low = 0;
        int high = maxh;
        while (low <= high) {
            int midHeight = (low + high) / 2;
            int totalWood = 0;

            for (int h : treeHeights) {
                if (h <= midHeight) {
                    totalWood += h; // Collect all wood if tree height <= midHeight
                } else {
                    totalWood += midHeight; // Collect wood up to midHeight for taller trees
                }
            }

            if (totalWood < m) {
                low = midHeight + 1; // Not enough wood, increase cutting height
            } else {
                high = midHeight; // Enough wood, might be able to cut lower (waste less)
            }
        }

        return low; // Minimum cutting height to get at least M meters of wood
    }

    public static void main(String[] args) {
        int[] treeHeights = { 6, 5, 3, 1, 8, 7 };
        int n = treeHeights.length;
        int m = 10;

        int minHeight = minCuttingHeight(treeHeights, n, m);
        System.out.println("Minimum cutting height: " + minHeight);
    }
}
