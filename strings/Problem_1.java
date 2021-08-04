package strings;

import java.util.*;

// Title ==> Reverse a string
public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // conversion from String object to StringBuffer
        StringBuffer sbr = new StringBuffer(input);
        sbr.reverse();
        System.out.println(sbr);
    }
}