package greedy;

// Find max sum possible equal sum of three stacks
public class Problem_35 {
    public static int maxEqualSum(int[] stack1, int[] stack2, int[] stack3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int num : stack1) sum1 += num;
        for (int num : stack2) sum2 += num;
        for (int num : stack3) sum3 += num;

        int i = 0, j = 0, k = 0;
        while (true) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1; // All sums are equal
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stack1[i++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stack2[j++];
            } else {
                sum3 -= stack3[k++];
            }

            if (i == stack1.length || j == stack2.length || k == stack3.length) {
                return 0; // No equal sum possible
            }
        }
    }

    public static void main(String[] args) {
        int[] stack1 = {3, 2, 1, 1, 1};
        int[] stack2 = {4, 3, 2};
        int[] stack3 = {1, 1, 4, 1};

        int result = maxEqualSum(stack1, stack2, stack3);
        System.out.println("Maximum possible equal sum of three stacks: " + result);
    }
}