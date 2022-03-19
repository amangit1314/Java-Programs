package strings;

import java.util.Scanner;

public class Remove_Duplicates {
    static final int NO_OF_CHARS = 256;

    static void fillCharCounts(String s, int[] count){
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;
    }

    public static void removeDuplicates(String s){
        int[] count = new int[NO_OF_CHARS];
        fillCharCounts(s, count);
        for (int i = 0; i < NO_OF_CHARS; i++)
            if(count[i] > 1)
                System.out.println((char)(i) + ", count = " + count[i]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        removeDuplicates(str);
    }
}