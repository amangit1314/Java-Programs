package heap;
import java.util.PriorityQueue;

// Problem Title => Kth large_st sum continuous sub-arrays
public class Problem_08 {

    // function to calculate Kth large_st sum
    public static int KthLargestSum(int[] a, int n, int k){

        // arrays.array to store predix sum
        int[] sums = new int[n + 1];
        sums[0] = 0;
        sums[1] = a[0];

        for(int i = 2; i <= n; i++)
            sums[i] = sums[i - 1] + a[i - 1];

        // priority queue of min heap
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        // loop to calculate the contiguous sub arrays.array sum position wise
        for(int i = 1; i <= n; i++){
            // loop to traverse all positions that form contiguous sub_array
            for(int j = 1; j <= n; j++){
                // calculates the contiguous sub-arrays.array sum from j to i index
                int x = sums[j] - sums[i - 1];

                // if queue has less than k elements, then simply push it
                if(Q.size() < k)
                    Q.add(k);

                else{
                    // If the min heap has equal to k elements then just check if the largest kth element is smaller than x then insert,
                    // Else it's of no use
                    if (Q.peek() < x) {
                        Q.poll();
                        Q.add(x);
                    }
                }

            }
        }
        // the top element will be then kth large_st element
        return Q.poll();
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 10, -10, 20, -40 };
        int n = a.length;
        int k = 6;

        // calls the function to find out the k-th large-st sum
        System.out.println(KthLargestSum(a, n, k));
    }
}