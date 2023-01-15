// Reverse the first K elements of a queue

package stack_and_queue;
import java.util.Queue;
import java.util.Stack;

public class P28 {

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();

        for(int i = 0; i < k; i++)
            s.push(q.poll());

        while(!s.isEmpty())
            q.add(s.pop());

        for (int i = 0; i < size - k; i++)
            q.add(q.poll());

        return q;
    }


    public static void main(String[] args) {

    }
}