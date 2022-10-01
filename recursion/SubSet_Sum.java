package recursion;

import java.util.ArrayList;


/**
 * Problem - Subset Sums
 * Given -  A list of N integers
 * Task - Print sums of all subsets in it
 * Note - Subset is a part of array
 */
public class SubSet_Sum {
    // a helper function to calculate subset sum
    public static void subSet(int index, ArrayList<Integer> arr, int n, int sum, ArrayList<Integer> mama ){
        // Base Case
        if(index == n){
            mama.add(sum);
            return;
        }

        // recursive formula
        sum += arr.get(index);
        // recursive call
        subSet(index+1, arr, n, sum, mama);

        // recursive formula
        sum += arr.get(index);
        // recursive call
        subSet(index+1, arr, n, sum, mama);
    }

    // a function to calculate subset sum
    public static ArrayList<Integer>  subSetSums(ArrayList<Integer> arr, int n){
        ArrayList<Integer> mama = new ArrayList<>();
        subSet(0, arr, n, 0, mama);
        return mama;
    }

    public static void main(String[] args) {

    }
}