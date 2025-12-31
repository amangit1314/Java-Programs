package arrays.array;

import java.util.*;
import java.lang.*;

// TITLE => find duplicate in an arrays.array of N+1 Integers
public class Problem11{

    static void printRepeating(int[] a, int size){
        int i;
        System.out.println("Repeating elements are: ");
        for(i = 0; i < size; i++){
            int j = Math.abs(a[i]);
            if(a[j] >= 0)
                a[j] = -a[j];
            else
                System.out.println(j + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] a = new int[size];
        for(int i = 0; i < size; i++)
            a[i] = sc.nextInt();
        Problem11.printRepeating(a, size);
    }
}