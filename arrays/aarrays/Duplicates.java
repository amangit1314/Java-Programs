package arrays.aarrays;

public class Duplicates {

    public static void printRepeating(int[] a, int n){
        for(int i = 0; i < n; i++){
            if(a[Math.abs(a[i])] >= 0)
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            else
                System.out.print(Math.abs(a[i]) + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,1,3,6,6};
        printRepeating(a,a.length);
    }
}