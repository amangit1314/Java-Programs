package searchingSortingProblems;

// Smallest number with atleastn trailing zeroes infactorial
public class SSP_Problem_30 {
    public static int findSmallestNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        int num = 1;
        int trailingZeroes = 0;

        while (trailingZeroes < n) {
            trailingZeroes = countTrailingZeroes(num);
            num++;
        }

        return num - 1; // Subtract 1 since the loop increments num after the check
    }

    private static int countTrailingZeroes(int num) {
        int count = 0;
        while (num > 0 && num % 5 == 0) {
            count++;
            num /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 3;

        int smallestNumber = findSmallestNumber(n);
        System.out.println("Smallest number with at least " + n + " trailing zeroes: " + smallestNumber);
    }
}
