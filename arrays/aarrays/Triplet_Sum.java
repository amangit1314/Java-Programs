package arrays.aarrays;
// Problem Title ->
public class Triplet_Sum {

    public boolean find3Numbers(int[] A, int a_size, int sum){
        int l, r;
        for(int i = 0; i < a_size - 2; i++) {
            for(int j = i + 1; j < a_size - 1; j++) {
                for(int k = j + 1; k < a_size; k++) {
                    if(A[i] + A[j] + A[k] == sum) {
                        System.out.println("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}