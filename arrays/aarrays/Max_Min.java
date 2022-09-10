package arrays.aarrays;
import java.util.*;

public class Max_Min {
    static class Pair{
        int max, min;
    }

    static Pair getMinMax(ArrayList<Integer> a, int n){
        Pair minmax = new Pair();

        if(n == 1){
            minmax.max = a.get(0);
            minmax.min = a.get(0);
            return minmax;
        }

        if(a.get(0) > a.get(1)){
            minmax.max = a.get(0);
            minmax.min = a.get(1);
        }

        else{
            minmax.max = a.get(1);
            minmax.min = a.get(0);
        }

        for(int i = 2; i < n; i++){
            if (a.get(i) > minmax.max)
                minmax.max = a.get(i);
            else if (a.get(i) < minmax.min)
                minmax.min = a.get(i);
        }
        return minmax;
    }

    public static void printArray(ArrayList<Integer> arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr.get(i) + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(5);
        a.add(9);
        a.add(8);
        a.add(7);
        a.add(4);
        printArray(a, a.size());
        int n = 6;
        Max_Min.Pair minmax = getMinMax(a, n);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}