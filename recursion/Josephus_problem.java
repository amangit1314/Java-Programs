package recursion;
import java.util.*;
/**
 * Given - The total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.
 * Task - The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle,
 *        you are the last one remaining and survive.
 * Input - n = 3, k = 2
 * Output: 3
 * Explanation: There are 3 persons so skipping 1 person such that 1st person 2nd person will be killed.
 *              Thus, the safe position is 3.
 */

public class Josephus_problem {

    public static int josephus(int m, int k) {
        if(m == 1)
            return 1;
        return (josephus(m-1 , k-1) + k-1) % m + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T --> 0) {
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            sc.close();

            System.out.println(Josephus_problem.josephus(n, k));
        }
    }
}