package problemsWIthName;
import java.util.Arrays;

public class Product_Of_Array_Except_Self {
    // brute force, Time: O(n^2), Space: O(n)
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public static int[] productExceptSelf(int[] nums) {

        // Approach: Using prefix and postfix
        // Idea: Just find prefix and postfix product and keep them in the ans array

        int ans[] = new int[nums.length];
        int pre = 1, post = 1;

        // find pre product
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }

        // find post product
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= post;
            post *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result)); // Output: [24, 12, 8, 6]
    }
}
