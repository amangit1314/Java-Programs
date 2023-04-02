package  patternsByloops;
/**
 *      1
 *     2 2
 *    3 3 3
 *   4 4 4 4
 *  5 5 5 5 5
 * */

public class NumberPattern1 {
    public static void main(String[] args) {
        System.out.println();

        for(int i = 1; i <= 5; i++) {
            for(int j = i; j <= 5; j++) {
                System.out.print(" ");
            }

            for(int k = 0; k < i; k++)
                System.out.print(i + " ");

            System.out.println();
        }
    }
}