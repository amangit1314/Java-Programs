package stack_and_queue;

// Java program to reverse a Queue by recursion

import java.util.LinkedList;
import java.util.Queue;

// Java program to reverse a queue recursively
public class P27 {

    static Queue<Integer> queue;

    // Utility function to print the queue
    static void Print() {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }

    // Recurrsive function to reverse the queue
    static Queue<Integer> reverseQueue(Queue<Integer> q) {
        // Base case
        if (q.isEmpty())
            return q;

        // Dequeue current item (from front)
        int data = q.peek();
        q.remove();

        // Reverse remaining queue
        q = reverseQueue(q);

        // Enqueue current item (to rear)
        q.add(data);

        return q;
    }

    // Driver code
    public static void main(String args[]) {
        queue = new LinkedList<Integer>();
        queue.add(56);
        queue.add(27);
        queue.add(30);
        queue.add(45);
        queue.add(85);
        queue.add(92);
        queue.add(58);
        queue.add(80);
        queue.add(90);
        queue.add(100);
        queue = reverseQueue(queue);
        Print();
    }
}