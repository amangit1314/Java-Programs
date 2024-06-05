package dp;

Class Coin_change_problem {
    static int count(int[] array, int m, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m <= 0)
            return 0;
        return count(array, m - 1, n) + count(array, m, n - array[m - 1]);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int m = a.length;
        System.out.println(count(a, m, 4));
    }
}