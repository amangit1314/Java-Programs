package arrays.aarrays;

import java.util.*;

public class Reverse_Array {
    public static void reverse(ArrayList<Integer> arr, int start, int end){
        while(start <= end){
            Collections.swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void printArray(ArrayList<Integer> arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr.get(i) + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.print("Given arrays.array is \n");
        printArray(arr, arr.size());
        reverse(arr, 0, arr.size()-1);
        System.out.print("Reversed arrays.array is \n");
        printArray(arr, 6);
    }
}