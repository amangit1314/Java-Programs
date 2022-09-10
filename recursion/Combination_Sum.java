package recursion;
import java.util.*;

/*
<---------------------------------------------------------------------------------------------------------------------->
Given - An arrays.array of integers and a sum B
NTD   - Find all unique combination's int the arrays.array where the sum is equal to B
Note  -  The same number may be chosen from the arrays.array any number of times to make B.
      1. All numbers will be positive integers.
      2. Elements in a combination (a1, a2, ..., ak) must be in ascending order i.e (a1 <= a2 <= ... <= ak).
      3. The combinations themselves must be stored in ascending order.
<---------------------------------------------------------------------------------------------------------------------->
* */

public class Combination_Sum {

    // <----------------- APPROACH ------------------------------------------------------------------------------------>
    // Take a HashSet of capacity of given List
    // Take a new_List of capacity of hashSet
    // Sort new_List
    // Take an ans ds
    // Combination(ans, new_List, int b, AL, 0)
    // finally return the ans
    // <--------------------------------------------------------------------------------------------------------------->

    public static void combination(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, int B, List<Integer> AL, int index){
        // base case
        if(index == A.size()){
            if(B == 0)
                ans.add(new ArrayList<>(AL));
            return;
        }

        // base case
        if (A.get(index) <= B){
            AL.add(A.get(index));
            AL.remove(AL.size()-1);
        }

        // recursive call
        combination(A, ans, B, AL, index+1);
    }

    public static void main(String[] args) {

    }
}

/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(X^2 * 2^N)
| Auxiliary Space ->  | O(X * 2^N)
<---------------------------------------------------------------------------------------------------------------------->
 */