package heap;
import java.util.*;

public class Problem_12 {

    static Queue<Integer> maxHeap = new PriorityQueue<>();
    static Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public static void insertHeap(int x) {
        // add your code here
        maxHeap.offer(x);
        balanceHeaps();
    }

    //Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here
        while(minHeap.size() > 0 && minHeap.peek() > maxHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }
        while(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }
        while(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    //Function to return Median.
    public static double getMedian() {
        // add your code here
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return (double)(maxHeap.peek() + minHeap.peek())/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n;
        while(t-- > 0) {
            n = sc.nextInt();

            for(int i = 1; i <= n; i++) {
                int x = sc.nextInt();
                insertHeap(x);
                System.out.println((int)Math.floor(getMedian()));
            }
        }
    }
}

