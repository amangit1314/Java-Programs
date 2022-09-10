package arrays.array;

import java.util.Scanner;

//Title : Java program to find the maximum & minimum element in given arrays.array
class Problem2{

    static class  Pair{
        int min, max;
    }
    static Pair getMinMax(int[] a, int n){
        Pair minMax = new Pair();
        int i;
        // BASE CASE
        if(n == 1) {
            minMax.max = a[0];
            minMax.min = a[0];
            return minMax;
        }

        //IF their are more than one elements THEN initialize min and max
        if (a[0] > a[1]){
            minMax.max = a[0];
            minMax.min = a[1];
        }else {
            minMax.max = a[1];
            minMax.min = a[0];
        }

        //IF their are so many or more than 2 elements in arrays.array THEN following loop will work
        for (i = 0; i < n; i++){
            if(a[i] > minMax.max)   minMax.max = a[i];
            else if(a[i] < minMax.min)   minMax.min = a[i];
        }

        return minMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Pair minMax = getMinMax(a, n);
        System.out.printf("\nMinimum element is %d", minMax.min);
        System.out.printf("\nMaximum element is %d", minMax.max);
    }
}