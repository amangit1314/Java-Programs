package arrays.aarrays;

public class Min_Jumps_to_end {

    static int minJumps(int[] array, int l, int h){
        //base
        if(h == l)  return 0;

        // when nothing is reachable from the source
        if(array[l] == 0)   return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        for(int i = l+1; i <= h && i <= l + array[l]; i++){
            int jumps = minJumps(array, i, h);
//            System.out.print(minJumps(arrays.array, i, h) + " ");
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is " + minJumps(arr , 0 , n -1 ));
    }
}