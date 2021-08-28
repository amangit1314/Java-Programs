package dp;
import java.util.*;

// Problem Title => Program for nth Catalan Number
public class DP_Problem_05 {
    static void catalan(int n){
        int cat = 1;
        System.out.println(cat + " ");
        for (int i = 1; i < n; i++){
            cat *= (4 * i - 2);
            cat /= (i + 1);
            System.out.print(cat + ' ');
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        catalan(n);
    }
}