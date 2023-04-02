package patternsByloops;

/**
 * A
 * A B
 * A B C
 * A B C D
 * A B C D E
 * */

public class AlphabatPattern3 {
    public static void main(String[] args) {
        char ch = 'A';
        for(int i = 1; i <= 5; i++) {
            ch = 'A';
            for(int j = 1; j<= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}