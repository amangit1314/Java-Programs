package stack_and_queue;
import java.util.Stack;

public class P7 {

    public static String reverse2(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            // stack se pop kiya
            Character sj = st.pop();

            // string builder me add kiya
            sb.append(sj);
        }

        // string = string-builder ka text
        str = sb.toString();

        // last m return string
        return str;
    }

    public static void main(String[] args) {
        //create a new string
        String s = "Aman";

        //print the reversed string
        System.out.println("Reversed string is " + reverse2(s));
    }
}