package arrays.aarrays;

import java.util.*;

public class Zero_Sum_Subarray {
    static Boolean subArrayExists(int[] a){
        // an empty hashset
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            // Add current element to sum
            sum += a[i];
            /*
             * Return true in following cases
             * a). Current element is 0
             * b). sum of elements from 0 to i is 0
             * c). sum is already present in hash map
             */

            if(a[i] == 0 || sum == 0 || set.contains(sum)) return true;

        }
        return false;
    }
    public static void main(String[] args) {
        int[] a = {2, 3, -1, -2, 4, 5};
        if(subArrayExists(a))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }
}