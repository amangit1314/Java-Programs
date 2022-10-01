package backtracking;
import java.util.*;
public class Max_possible_no_by_doing_atmost_k_swaps {
    static String strMax = "";

    public static String findMaximumNum(String str, int k) {
        strMax = "";
        char[] arr = str.toCharArray();
        findNum(arr, k);
        if (strMax.isEmpty())
            return str;
        return strMax;
    }

    public static void findNum(char[] arr, int k) {
        if (k == 0) return;
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                char a = arr[i];
                char b = arr[j];

                if(a < b) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    String toStr = String.valueOf(arr);

                    if(toStr.compareTo(strMax) > 0)
                        strMax = toStr;

                    findNum(arr, k - 1);
                }

                if(a < b) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main (String[]args){

    }
}