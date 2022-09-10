package miscellaneous.aoa_lab;
import java.util.*;

public class Optimal_Merge {

    public static int minComputations(int[] files, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            pq.add(files[i]);
        }

        int count = 0;
        System.out.println("\nThe merged file sequence is: ");
        while(pq.size() > 1){
            int temp = pq.poll() + pq.poll();
            count += temp;
            pq.add(temp);

            System.out.print(temp + " ");
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] files = new int[n];
        System.out.print("\n"+ " Given arrays.array is: ");
        for(int i = 0; i < n; i++){
            files[i] = sc.nextInt();
            System.out.print(files[i] + " ");
        }
        System.out.println();

        Arrays.sort(files);

        System.out.println("\nThe sorted arrays.array is: ");
        for (int num: files) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\nMinimum no of computations are: " + minComputations(files, n));
    }
}