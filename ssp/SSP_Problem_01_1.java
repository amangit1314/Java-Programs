package ssp;
import java.util.*;

class SSP_Problem_01_1{

    static void findFirstAndLast(int[] a, int x){
        int n = a.length;
        int first = -1, last = -1;

        for(int i = 0; i < n-1; i++){
            if(x != a[i])   continue;
            if(first == -1)    first = i;
            last = i;
        }
        if(first != -1){
            System.out.println("First Occurrence = " + first);
            System.out.println("Last Occurrence = " + last);
        }
        else    System.out.println("Not Found");
    }

   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int x = sc.nextInt();
        findFirstAndLast(arr, x);
   }
}