package compiler_lab_java;
import java.util.*;

public class String_is_Keyword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        String[] keywords= { "break", "case", "continue", "default",
                "defer", "else", "for", "int", "goto",
                "if", "static", "boolean", "return", "extends",
                "public", "var"
        };

        for (String keyword : keywords) {
            if (word.equals(keyword)) {
                System.out.println(word + " is a keyword");
            }
            else{
                System.out.println(word + " is not a keyword");
            }
            break;
        }
    }
}