package recursion;

/*
<---------------------------------------------------------------------------------------------------------------------->
Given - Non negative integer N.
NTD   - For N find the next smallest Happy Number.
<---------------------------------------------------------------------------------------------------------------------->
Scenario  -
      A number is called happy if  :
      . It leads to a sequence of steps
      . Wherein each step number is replaced by the sum of squares of its digit
      . That is if we start with Happy Number and
      . Keep replacing it with digits square sum, we reach 1
<---------------------------------------------------------------------------------------------------------------------->
Example -
      input -> N = 8.
      output -> 10.
      explanation -> 1*1 + 0*0 = 1, hence after 8, 10 is the next happy number.
<---------------------------------------------------------------------------------------------------------------------->
* */

import java.util.HashSet;

public class Next_Happy_Number {
    public static int nextHappy(int N){
        for(int i = N+1; ; i++){
            if(isHappy(i) == true)
                return i;
        }
    }
    public static boolean isHappy(int n){

        if(n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while(n != -1){
            sum = 0;
            while(n > 0){
                int d = n%10;
                sum += d*d;
                n = n/10;
            }
            n = sum;
            if(!set.contains(n))
                set.add(n);

            else return false;
            if(sum == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(n)
| Auxiliary Space ->  | O(n)
<---------------------------------------------------------------------------------------------------------------------->
 */