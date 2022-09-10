package stack_and_queue.practice;

import java.util.*;

public class StackByQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    static void push(int element) {
        q2.add(element);

        while(!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swapping the queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    static void pop() {
        if(q1.isEmpty())
            return;
        q1.remove();
    }

    static int top() {
        if(q1.isEmpty())
            return -1;

        return q1.peek();
    }

    static int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);

        System.out.println("current size: " + size());
        System.out.println(top());
        pop();
        System.out.println(top());
        pop();
        System.out.println(top());

        System.out.println("current size: " + size());
    }
}