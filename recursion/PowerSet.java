package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PowerSet {

    static void printSubset(int[] input, int[] output, int idx){
        int totalSubset = 0, n = 3;;
        if(idx >= input.length){
            for (int i: output)
                System.out.print(i + " ");
            System.out.println();
            totalSubset++;
            return;
        }

        // not included
        printSubset(input, output, idx++);

        // included
        add(n,output,input[idx]);
        printSubset(input,output,idx++);
    }

    // Function to add x in arr
    public static int[] add(int n, int[] input, int x) {
        int i;
        // create a new arrays.array of size n+1
        int[] new_arr = new int[n + 1];
        // insert the elements from the old arrays.array into the new arrays.array insert all elements till n then insert x at n+1
        for (i = 0; i < n; i++)
            new_arr[i] = input[i];
        new_arr[n] = x;
        return new_arr;
    }

    public static void main(String[] args) {
        int[] input = {2,9,7};
        int[] output = {};
        printSubset(input, output, 3);
    }
}