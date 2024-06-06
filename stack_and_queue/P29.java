package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

// Interleave the first half of the queue with second half

public class P29 {

    public static void interLeaveQueue(Queue<Integer> q) {
        if (q.size() % 2 != 0)
            System.out.println("Input even no of integers");

        Queue<Integer> temp = new LinkedList<>();
        int half_size = q.size() / 2;

        for (int i = 0; i < half_size; i++) {
            temp.add(q.element());
            q.poll();
        }

        while (!temp.isEmpty()) {
            q.add(temp.element());
            q.add(q.element());
            q.poll();
            temp.poll();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();
        // Add numbers to end of Queue
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);

        System.out.println("Queue: " + Q);

        interLeaveQueue(Q);

        System.out.println("Queue: " + Q);
    }
}