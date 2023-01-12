package arrays.interviewProblems;

public class KadanesAlgorithm {
    public static void maxSubArraySum(int[] array) {
        int size = array.length;
        int curr = Integer.MIN_VALUE, max = 0;

        for(int i = 0; i < size; i++) {
            max = max + array[i];
            if(curr < max)
                curr = max;

            if(max < 0)
                max = 0;
        }

        System.out.println(max);
    }

    public static void main(String[] args) {

    }
}