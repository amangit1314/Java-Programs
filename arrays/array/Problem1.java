package arrays.array;
import java.util.Scanner;
//Title :- Java program to reverse the given arrays.array
class Problem1{

    static void reverseArray(int[] a, int start, int end){
        int temp;
        while(start < end){
            temp = a[end];
            a[end] = a[start];
            a[start] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int[] a, int n){
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Reversing is ");
        printArray(a, n);

        reverseArray(a,0,n-1);

        System.out.println("Reversed Array is ");
        printArray(a, n);
    }
}