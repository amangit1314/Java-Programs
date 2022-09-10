package arrays.aarrays;
import java.util.*;

public class Sort012 {
    // Sort the input arrays.array, the arrays.array is assumed they have values in {0, 1, 2}
    static void sort012(ArrayList<Integer> arr, int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp;
        while (mid <= hi) {
            switch (arr.get(mid)) {
                case 0 -> {
                    temp = arr.get(lo);
                    int a = arr.get(lo);
                    a = arr.get(mid);
                    int b = arr.get(mid);
                    b = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = arr.get(mid);
                    int a = arr.get(mid);
                    a = arr.get(hi);
                    int b = arr.get(hi);
                    b = temp;
                    hi--;
                }
            }
        }
    }

    static void printArray(ArrayList<Integer> arr, int arr_size) {
        for (int i = 0; i < arr_size; i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        int arr_size = arr.size();
        sort012(arr, arr_size);
        System.out.println("Array after segregation ");
        printArray(arr, arr_size);
    }
}