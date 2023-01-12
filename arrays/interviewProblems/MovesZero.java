package arrays.interviewProblems;

class MoveZero {
    public static void moveZeroes(int[] nums) {
        int i = 0, temp;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != 0) {
                // swap nums[j] to nums[i]
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0, 12, 0, 9, 3, 0, 0};
        printArray(nums, nums.length);
        moveZeroes(nums);
        printArray(nums, nums.length);
    }
}