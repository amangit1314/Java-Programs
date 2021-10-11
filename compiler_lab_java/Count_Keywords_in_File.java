package compiler_lab_java;

import java.io.*;
import java.util.*;

public class Count_Keywords_in_File {

    public static void main(String[] args) throws Exception {

        int count = 0;

        String[] keywords= { "break", "case", "continue", "default",
                             "defer", "else", "for", "int", "goto",
                             "if", "static", "boolean", "return", "extends",
                             "public", "var"
        };

        FileReader file = new FileReader("src/compiler_lab_java/data.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){
            String word = sc.next();
            for (String keyword : keywords) {
                if (word.equals(keyword)) {
                    count++;
                }
            }
        }

        System.out.println("Number of keywords present in given file: " + count);
        sc.close();
    }
}