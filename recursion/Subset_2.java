package recursion;
import java.util.*;

/**
 * Problem - Subset 2
 * Given - array of integers "that may contain duplicates" the task is to .
 * Task - Return all possible subsets.
 * Note - Return only unique subsets, and they can be in any order.
 *
 * Example 1:
 *      Input: array[] = [1,2,2]
 *      Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]
 *      Explanation: We can have subsets ranging from  length 0 to 3. which are listed above.
 *                   Also, the subset [1,2] appears twice but is printed only once as we require only unique subsets.
 *
 * Example 2:
 *      Input: array[] = [1]
 *      Output: [ [ ], [1] ]
 *      Explanation: Only two unique subsets are available
 */

public class Subset_2 {

    /**
     * List<List<Integer>> output = new ArrayList();
     *     int n, k;
     *     public List<List<Integer>> subsetsWithDup(int[] nums) {
     * 	    Arrays.sort(nums);
     * 	    n = nums.length;
     * 	    for (k = 0; k < n+1; k++) {
     * 		    backtrack(0, new ArrayList<Integer>(), nums);
     *                }
     * 	    return output;
     *     }
     *
     *     public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
     * 	    if (curr.size() == k) {
     * 		    output.add(new ArrayList(curr));
     * 		    return;
     *        }
     * 	    for (int i = first; i < n; i++) {
     * 		    if(i > first && nums[i] == nums[i-1])
     *                 continue;
     * 		    curr.add(nums[i]);
     * 		    backtrack(i + 1, curr, nums);
     * 		    curr.remove(curr.size() - 1);
     *        }
     *     }
     */

    static void printAns(List <List<Integer>>  ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(","," "));
    }

    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i = ind; i < nums.length; i++) {
            if(i != ind && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);

            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List < List<Integer>> ans = subsetsWithDup(nums);
        printAns(ans);
    }
}

/**
 * Time Complexity:
 *          O(2^n) for generating every subset and
 *          O(k) to insert every subset in another data structure if the average length of every subset is k.
 *          Overall O(k * 2^n).
 *
 * Space Complexity:
 *          O(2^n * k) to store every subset of average length k.
 *          Auxiliary space is O(n)  if n is the depth of the recursion tree.
 */