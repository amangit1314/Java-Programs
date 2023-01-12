package arrays.interviewProblems;

public class TrappingRainWater1 {

   static void trappedWater(int[] heights) {
        // right array
        int[] right = new int[heights.length];

        // left array
        int[] left = new int[heights.length];

        // put left[0] = heights[0]
        left[0] = heights[0];

        // left max heights ------------------------->
        for(int i = 1; i < heights.length; i++) {
            left[i] = Math.max(left[i-1], heights[i]);
        }

        // <------------------------ right max heights
        right[heights.length - 1] = heights[heights.length - 1];
        for(int i = heights.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], heights[i]);
        }

        int ans = 0;

        // formula to calculate the trapped water [ans = ans + max(left[i] , right[i]) - heights[i];]
        for(int i = 0; i < heights.length; i++) {
            ans += (Math.min(left[i], right[i]) - heights[i]);
        }

        // printing the answer
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] heights = {3, 1, 2, 4, 0, 1, 3, 2};
        trappedWater(heights);
    }
}