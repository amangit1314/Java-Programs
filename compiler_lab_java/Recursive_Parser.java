package compiler_lab_java;

import java.util.*;
/*
* 	My Grammar :
	E -> x + T
	T -> (E)
	T -> x
* */
class Recursive_Parser {
    static int ip;
    static char[] input;

    public static void main(String[] args) {
        System.out.println("Enter the desired input string:");
        String s = new Scanner(System.in).nextLine();
        input = s.toCharArray();
        if(input.length < 2) {
            System.out.println("The input string is invalid.");
            System.exit(0);
        }
        ip = 0;
        boolean isValid = E();
        if((isValid) & (ip == input.length)) {
            System.out.println("The input string is valid.");
        } else {
            System.out.println("The input string is invalid.");
        }
    }

    static boolean E() {
        // Check if 'ptr' to 'ptr+2' is 'x + T'
        int fallback = ip;
        if(input[ip++] != 'x') {
            ip = fallback;
            return false;
        }
        if(input[ip++] != '+') {
            ip = fallback;
            return false;
        }
        if(!T()) {
            ip = fallback;
            return false;
        }
        return true;
    }

    static boolean T() {
        // I am Checking that if 'ptr' to 'ptr+2' is '(E)' or if 'ptr' is 'x'
        int fallback = ip;
        if(input[ip] == 'x') {
            ip++;
        }
        else {
            if(input[ip++] != '(') {
                ip = fallback;
                return false;
            }
            if(!E()) {
                ip = fallback;
                return false;
            }
            if(input[ip++] != ')') {
                ip = fallback;
                return false;
            }
        }
        return true;
    }
}