package arrays;
import java.util.*;

// Find the majority element in java, B
class Majority_Elements_linear {

    private static void findMajority(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int j : arr) {
            if (map.containsKey(j)) {
                int count = map.get(j) + 1;
                if (count > arr.length / 2) {
                    System.out.println("Majority found :- " + j);
                    return;
                } else
                    map.put(j, count);
            } else
                map.put(j, 1);
        }
        System.out.println(" No Majority element");
    }


    /* Driver program to test the above functions */
    public static void main(String[] args) {
        int[] a = new int[] {2,2,2,2,5,5,2,3,3};

        findMajority(a);
    }
}