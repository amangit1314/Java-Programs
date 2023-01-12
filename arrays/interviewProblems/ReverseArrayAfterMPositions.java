package arrays.interviewProblems;

import oops.encapsulation.S;

public class ReverseArrayAfterMPositions {

    public static void reverseArrayAfterMPositions(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    /*
     * Utility that prints out an arrays.array on a line
     */
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {11, 7, 3, 12, 4};
        int m = 2;
        printArray(array, array.length);
        reverseArrayAfterMPositions(array, m + 1, array.length - 1);
        printArray(array, array.length);
    }
}