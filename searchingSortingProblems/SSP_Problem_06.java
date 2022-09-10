package searchingSortingProblems;
//Problem Title => Optimum location of point to minimize total distance
 
public class SSP_Problem_06 {

    static double sq(double x) {
        return ((x) * (x));
    }

    static int EPS = 1;
    static int N = 5;

    // structure defining a point
    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // structure defining a line of ax + by + c = 0 form
    static class line {
        int a, b, c;

        public line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // method to get distance of point (x, y) from point p
    static double dist(double x, double y, point p) {
        return Math.sqrt(sq(x - p.x) + sq(y - p.y));
    }

    /* Utility method to compute total distance all points
        when choose point on given line has x-coordinate
        value as X */
    static double compute(point[] p, int n, line l, double X) {
        double res = 0;

        // calculating Y of chosen point by line equation
        double Y = -1 * (l.c + l.a * X) / l.b;
        for (int i = 0; i < n; i++)
            res += dist(X, Y, p[i]);

        return res;
    }

    // Utility method to find minimum total distance
    static double findOptimumCostUtil(point[] p, int n, line l) {
        double low = -1e6;
        double high = 1e6;

        // loop until difference between low and high
        // become less than EPS
        while ((high - low) > EPS) {
            // mid1 and mid2 are representative x
            // coordinates of search space
            double mid1 = low + (high - low) / 3;
            double mid2 = high - (high - low) / 3;

            double dist1 = compute(p, n, l, mid1);
            double dist2 = compute(p, n, l, mid2);

            // if mid2 point gives more total distance,
            // skip third part
            if (dist1 < dist2)
                high = mid2;

                // if mid1 point gives more total distance,
                // skip first part
            else
                low = mid1;
        }

        // compute optimum distance cost by sending average
        // of low and high as X
        return compute(p, n, l, (low + high) / 2);
    }

    // method to find optimum cost
    static double findOptimumCost(int[][] points, line l) {
        point[] p = new point[N];

        // converting 2D arrays.array input to point arrays.array
        for (int i = 0; i < N; i++)
            p[i] = new point(points[i][0], points[i][1]);

        return findOptimumCostUtil(p, N, l);
    }

    // Driver Code
    public static void main(String[] args) {
        line l = new line(1, -1, -3);
        int[][] points = {
                { -3, -2 },
                { -1, 0 },
                { -1, 2 },
                { 1, 2 },
                { 3, 4 }
        };
        System.out.println(findOptimumCost(points, l));
    }
}