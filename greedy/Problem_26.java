package greedy;

// DIEHARD - Die Hard
public class Problem_26 {
    public static int minStepsToMeasure(int a, int b, int c) {
        if (c > Math.max(a, b)) {
            return -1;
        }
        if (c % gcd(a, b) != 0) {
            return -1;
        }
        return Math.min(pour(a, b, c), pour(b, a, c));
    }

    private static int pour(int fromCap, int toCap, int d) {
        int from = fromCap;
        int to = 0;
        int step = 1;

        while (from != d && to != d) {
            int temp = Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            step++;

            if (from == d || to == d) {
                break;
            }

            if (from == 0) {
                from = fromCap;
                step++;
            }

            if (to == toCap) {
                to = 0;
                step++;
            }
        }
        return step;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 3; // Capacity of jug A
        int b = 5; // Capacity of jug B
        int c = 4; // Desired amount

        int result = minStepsToMeasure(a, b, c);
        if (result == -1) {
            System.out.println("It's not possible to measure the desired amount.");
        } else {
            System.out.println("Minimum number of steps required: " + result);
        }
    }
}
     