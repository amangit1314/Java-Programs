package stack_and_queue;

// .. First negative integer in every window of size "K"

public class P33 {

    public long[] printFirstNegativeInteger(long[] a, int n, int k) {
        long[] list = new long[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int c = 0, count = 0;
            while (c < k) {
                if ((int) a[c + i] < 0) {
                    list[i] = a[c + i];
                    count = count + 1;
                    break;
                }
                c = c + 1;
            }

            if (count == 0)
                list[i] = (long) 0;

            count = 0;
        }

        return list;
    }

    public static void main(String[] args) {

    }
}