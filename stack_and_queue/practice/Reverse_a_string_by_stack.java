package stack_and_queue.practice;

import java.util.*;
public class Reverse_a_string_by_stack {

    public static void reverse(StringBuffer str){
        Stack<Character> s = new Stack<>();

        int i;

        for(i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            s.push(ch);
        }

        while(!s.isEmpty()){
            char ch = s.pop();
            str.setCharAt(i, ch);
        }

    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        reverse(str);
        System.out.println(" Reversed string is -> " + str );
    }
}