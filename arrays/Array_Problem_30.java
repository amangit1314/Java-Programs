package arrays;
/* Problem Title :-> Trapping Rain water problem */
public class Array_Problem_30 {
    //Function to return the maximum water that can be stored
    public static int maxWater(int[] a, int n) {

        int res = 0;

        // For every element of the array, except first and last element
        for(int i = 1; i < n - 1; i++) {

            // Find max element on its left
            int left = a[i];
            for(int j = 0; j < i; j++) {
                left = Math.max(left, a[j]);
            }

            // Find max element on its right
            int right = a[i];
            for(int j = i + 1; j < n; j++) {
                right = Math.max(right, a[j]);
            }

            //Update maximum water value
            res += Math.min(left, right) - a[i];
        }

        return res;
    }

    //Driver Code
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = a.length;
        System.out.print(maxWater(a, n));
    }

}
