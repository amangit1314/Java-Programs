package arrays.array;

import java.util.Scanner;

// TITLE => Move all negative elements to one side of arrays.array.
public class Problem5{

    static  void rearrange(int[] a, int n){
        int j = 0, temp;
        for(int i = 0; i < n; i++){
            if(a[i] < 0){
                if(i != j){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                j++;
            }
        }
    }

    static void printArray(int[] a, int n){
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        rearrange(a,n);
        printArray(a,n);
    }
}