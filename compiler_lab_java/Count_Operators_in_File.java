package compiler_lab_java;

import java.io.*;
import java.util.*;

public class Count_Operators_in_File {

    public static void main(String[] args) throws Exception {

        int count = 0;

        String[] operators = {
                "+", "*", "-", "/", "%", "&",
                "&&", "++", "--", "=", "==",
                "!=", "^", "||", ".", "?", ":",
                ";", "<<" , ">>", ">>>", ",", "+=",
                "-=", "*=", "/=", "%=", "&=", "^=",
                "|=", "<<=", ">>=", ">>>=", "<", ">",
                "<=", ">=", "instanceof", "++expr", "--expr",
                "+expr",  "-expr",  "~",  "!", "expr++", "expr--"
        };

        FileReader file = new FileReader("src/compiler_lab_java/data.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNext()){
            String current = scanner.next();
            for (String operator : operators) {
                if (current.equals(operator))
                    count++;
            }
        }

        System.out.println();
        System.out.println("Number of operators present in given file: " + count);
        scanner.close();
    }
}