package stack_and_queue.practice;
import java.util.*;

public class QueueByStack {

    static class Queue { Stack<Integer> stack1; }

    static void push(Stack<Integer> top_ref, int new_data) {
        top_ref.push(new_data);
    }

    static int pop(Stack<Integer> top_ref) {
        if(top_ref == null) {
            System.out.println("Stack underflow");
            System.exit(0);
        }
        return top_ref.pop();
    }

    static void enQueue(Queue q, int x) {
        push(q.stack1, x);
    }

    static int dequeue(Queue q) {
        int x, res = 0;
        /* If the stacks is empty then error */
        if (q.stack1.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }
        // Check if it is a last element of stack
        else if (q.stack1.size() == 1) {
            return pop(q.stack1);
        }
        else {

            /* pop an item from the stack1 */
            x = pop(q.stack1);

            /* store the last deQueued item */
            res = dequeue(q);

            /* push everything back to stack1 */
            push(q.stack1, x);
            return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.stack1 = new Stack<>();

        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);

        /* Dequeue items */
        System.out.print(dequeue(q) + " ");
        System.out.print(dequeue(q) + " ");
        System.out.print(dequeue(q) + " ");
    }
}