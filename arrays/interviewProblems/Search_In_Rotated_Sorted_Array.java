package arrays.interviewProblems;

public class Search_In_Rotated_Sorted_Array {

    public static int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
            continue;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 0, 1 , 2};
        int target = 1;

        System.out.println(search(arr, target));
    }
}