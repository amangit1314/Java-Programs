package stack_and_queue;

import java.util.*;

// Problem Title => Design a stack that supports getMin() in O(1) time and O(1) extra space
class MinimumStack {
    Stack<Node> s;

    static class Node{
        int val;
        int min;
        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }

    /** initialize your data structure here. */
    public MinimumStack() {
        this.s= new Stack<>();
    }
    public void push(int x) {
        if(s.isEmpty())
            this.s.push(new Node(x, x));
        else{
            int min=Math.min(this.s.peek().min,x);
            this.s.push(new Node(x, min));
        }
    }

    public int pop() {
        return this.s.pop().val;
    }

    public int top() {
        return this.s.peek().val;
    }

    public int getMin() {
        return this.s.peek().min;
    }
}

public class P8 {
    public static void main (String[] args) {
        MinimumStack s = new MinimumStack();
        s.push(-1);
        s.push(10);
        s.push(-4);
        s.push(0);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.getMin());
    }
}
