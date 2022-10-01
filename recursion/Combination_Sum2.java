package recursion;

import java.util.*;

public class Combination_Sum2 {
    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        util(candidates, target, -1);
        return res;
    }

    public void util(int[] nums, int k, int pos){
        if(k == 0){
            if(!res.contains(list))
                res.add(new ArrayList<>(list));
        }

        for(int i = pos+1; i < nums.length; i++){
            if(i > pos+1 && nums[i] == nums[i-1])
                continue;

            if(k - nums[i] < 0)
                break;

            list.add(nums[i]);
            util(nums, k-nums[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}