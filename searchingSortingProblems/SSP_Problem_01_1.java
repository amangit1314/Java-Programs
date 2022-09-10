package searchingSortingProblems;
import java.util.Scanner;
//  Problem Title => Find first and last occurrence of an elements in given sorted arrays.array

public class SSP_Problem_01_1 {

    // Function for finding first and last occurrence of an elements
    public static void findFirstAndLast(int[] arr, int x) {
        int n = arr.length;
        int first = -1, last = -1;

        for (int i = 0; i < n; i++) {
            if (x != arr[i])
                continue;

            if (first == -1)
                first = i;

            last = i;
        }

        if (first != -1) {
            System.out.println("First Occurrence = " + first);
            System.out.println("Last Occurrence = " + last);
        }

        else
            System.out.println("Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] arr = new int[x];
        for(int i = 0; i < x; i++)
            arr[i] = sc.nextInt();

        findFirstAndLast(arr, x);
    }
}