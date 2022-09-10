package stack_and_queue.practice;

import java.util.Stack;

public class Reverse_Stack_Recursion {
    static Stack<Character> st = new Stack<>();

    static void insert_at_bottom(char x){
        if(st.isEmpty())
            st.push(x);

        else{
            char a = st.peek();
            st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }

    static void reverse(){
        if(st.size() > 0){
            char x = st.peek();
            st.pop();
            reverse();
            insert_at_bottom(x);
        }
    }

    public static void main(String[] args) {

    }
}