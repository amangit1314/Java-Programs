package stack_and_queue;


import java.util.Stack;

public class P22 {

    static boolean checkStackPermutation(int[] ip, int[] op, int n){
        Stack<Integer> s = new Stack<>();
        int j = 0;

        for(int i = 0; i < n; i++) {
            s.push(ip[i]);
            while(!s.isEmpty() && s.peek() == op[j]) {
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {

    }
}