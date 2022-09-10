package arrays.aarrays;

public class Rearrange_in_neg_pov{

    void rightRotate(int[] a, int n, int outofplace, int cur){
        int temp = a[cur];
        if (cur - outofplace >= 0) System.arraycopy(a, outofplace, a, outofplace + 1, cur - outofplace);

        a[outofplace] = temp;
    }
    public static void main(String[] args) {

    }
}