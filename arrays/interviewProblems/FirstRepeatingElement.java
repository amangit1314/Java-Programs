package arrays.interviewProblems;

public class FirstRepeatingElement {

    static void repeatingElement(int[] arr) {
        int N = (int) (1e6+2);
        int[] idx = new int[N];

        for(int i = 0; i < N; i++) {
            idx[i] = -1;
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < arr.length; j++) {
            if (idx[arr[j]] != -1)
                min = Math.min(min, idx[arr[j]]);

            else
                idx[j] = j;
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);

        else
            System.out.println(min + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 3, 5, 6};
        repeatingElement(arr);
    }
}