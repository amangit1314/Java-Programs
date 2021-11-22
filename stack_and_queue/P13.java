package stack_and_queue;

import java.util.Stack;

// Problem Title => Implement a method to insert an element at its bottom without using any other data structure.
public class P13 {

    static void insertToBottom(Stack<Integer> s, int n){
        Stack<Integer> temp = new Stack<>();

        while (!s.empty()){
            temp.push(s.peek());
            s.pop();
        }

        s.push(n);

        while(!temp.empty()){
            s.push(temp.peek());
            temp.pop();
        }

        while(!s.empty()){
            System.out.println(s.peek() + " ");
            s.pop();
        }
    }

    // Driver function
    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(5);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);

        int N = 7;
        insertToBottom(S, N);
    }
}