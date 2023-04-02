package patternsByloops;
/**
 * 1
 * 1 2
 * 1 2 3
 * 1 2 3 4
 * 1 2 3 4 5
 * */
public class NumberPattern2 {
    public static void main(String[] args) {
        int n = 1;

        for(int i = 1; i <= 5; i++) {
            n = 1;
            for(int j = 1; j <= i; j++) {
                System.out.print(n + " ");
                n++;
            }
            System.out.println();
        }
    }
}