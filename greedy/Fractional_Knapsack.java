package greedy;

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
  double fractionalKnapsack(int W, Item arr[], int n) {
    // Your code here
    Arrays.sort(
      arr,
      new Comparator<Item>() {

        public int compare(Item a, Item b) {
          double r1 = (double) a.value / (double) a.weight;
          double r2 = (double) b.value / (double) b.weight;
          return Double.compare(r2, r1);
        }
      }
    );
    double finalvalue = 0.0;
    for (int i = 0; i < n; i++) {
      if (arr[i].weight <= W) {
        W -= arr[i].weight;
        finalvalue += arr[i].value;
      } else {
        finalvalue += arr[i].value * ((double) W / (double) arr[i].weight);
        break;
      }
    }
    return finalvalue;
  }

  public static void main(String[] args) {}
}
/*
<---------------------------------------------------------------------------------------------------------------------->
| Time Complexity ->  | O(n.logn)
| Auxiliary Space ->  | O(1)
<---------------------------------------------------------------------------------------------------------------------->
 */
