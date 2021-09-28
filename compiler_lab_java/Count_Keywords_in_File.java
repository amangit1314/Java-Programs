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
            for(int i = 0; i < keywords.length; i++){
                if(word.equals(keywords[i])){
                    count++;
                }
            }
        }

        System.out.println("Number of keywords present in given file: " + count);
        sc.close();
    }
}