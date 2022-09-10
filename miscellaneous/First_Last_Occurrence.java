package miscellaneous;
import java.util.*;

// Problem Title => First and last Occurrence of elements in arrays.array using arraylist

public class First_Last_Occurrence {

    // This function will return first index of element
    public static int first(ArrayList list, int x){
        return list.indexOf(x);
    }

    // This function will return last index of element
    public static int last(ArrayList list, int x){
        return list.lastIndexOf(x);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        ArrayList<Integer> cyclist = new ArrayList<>();

        // adding elements of arrays.array to ArrayList
        for (int i : arr)
            cyclist.add(i);

        int x = 8;

        // displaying the first occurrence
        System.out.println("First Occurrence = " + first(cyclist, x));

        // displaying the last occurrence
        System.out.println("Last Occurrence = " + last(cyclist, x));
    }
}