package greedy;
import java.util.*;

/*
<---------------------------------------------------------------------------------------------------------------------->
Given - weights and values of N items.
NTD   - we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
<---------------------------------------------------------------------------------------------------------------------->
Note: Unlike 0/1 knapsack, you are allowed to break the item. 
<---------------------------------------------------------------------------------------------------------------------->
Example -
      input -> N = 3, W = 50, values[] = {60,100,120}, weight[] = {10,20,30}
      output -> 240.00
      explanation -> Total maximum value of item can have is 240.00 from the given
                     capacity of sack.
<---------------------------------------------------------------------------------------------------------------------->
* */

class Fractional_Knapsack {

  //Function to get the maximum total value in the knapsack.
  private static double getMaxValue(int[] wt, int[] val, int capacity) {

    ItemValue[] iVal = new ItemValue[wt.length];

    for (int i = 0; i < wt.length; i++)
      iVal[i] = new ItemValue(wt[i], val[i], i);

    // sorting items by value;
    Arrays.sort(iVal, new Comparator<ItemValue>() {
      @Override
      public int compare(ItemValue o1, ItemValue o2) {
        return o2.cost.compareTo(o1.cost);
      }
    });

    double totalValue = 0d;

    for (ItemValue i : iVal) {

      int curWt = (int)i.wt;
      int curVal = (int)i.val;

      if (capacity - curWt >= 0) {
        // this weight can be picked while
        capacity = capacity - curWt;
        totalValue += curVal;
      }
      else {
        // item can't be picked whole
        double fraction = ((double)capacity / (double)curWt);
        totalValue += (curVal * fraction);
        capacity = (int)(capacity - (curWt * fraction));
        break;
      }
    }

    return totalValue;
  }

  // item value class
  static class ItemValue {
    Double cost;
    double wt, val, ind;

    // item value function
    public ItemValue(int wt, int val, int ind)
    {
      this.wt = wt;
      this.val = val;
      this.ind = ind;
      cost = new Double((double)val / (double)wt);
    }
  }

  // Driver code
  public static void main(String[] args)
  {
    int[] wt = { 10, 40, 20, 30 };
    int[] val = { 60, 40, 100, 120 };
    int capacity = 50;

    double maxValue = getMaxValue(wt, val, capacity);

    // Function call
    System.out.println("Maximum value we can obtain = " + maxValue);
  }
}
/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(n.logn)
| Auxiliary Space ->  | O(1)
<---------------------------------------------------------------------------------------------------------------------->
 */
