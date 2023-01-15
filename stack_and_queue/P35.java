package stack_and_queue;

// Sum of minimum and maximum elements of all sub arrays

import java.util.Deque;
import java.util.LinkedList;

public class P35 {

    public static int sumOfSubArray(int[] arr, int k) {
        int sum = 0;
        Deque<Integer> s = new LinkedList<>();
        Deque<Integer> g = new LinkedList<>();

        int i = 0;
        for(i = 0; i < k; i++) {
            while(!s.isEmpty() && arr[s.peekLast()] >= arr[i])
                s.removeLast();

            while(!g.isEmpty() && arr[g.peekLast()] <= arr[i])
                g.removeLast();

            g.addLast(i);
            s.addLast(i);
        }

        for(; i < arr.length; i++) {
            sum += arr[s.peekFirst()] + arr[g.peekFirst()];

            while(!s.isEmpty() && s.peekLast() <= i - k)
                s.removeFirst();

            while(!g.isEmpty() && g.peekFirst() <= i - k)
                g.removeLast();

            while(!s.isEmpty() && arr[s.peekLast()] >= arr[i])
                s.removeLast();

            while(!g.isEmpty() && arr[g.peekLast()] <= arr[i])
                g.removeLast();

            g.addLast(i);
            s.addLast(i);
        }
        sum += arr[s.peekFirst()] + arr[g.peekFirst()];
        return sum;
    }

    public static void main(String[] args) {

    }
}