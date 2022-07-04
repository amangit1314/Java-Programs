package recursion;

public class Reverse_an_array {
    void reverseArray(int[] x){
        reverse(x, 0, x.length -1);
    }

    void reverse(int[] x, int i, int j){
        if(i<j){
            // swapping
            int tmp = x[i];
            x[i] = x[j];
            x[j] = tmp;

            // recursive call
            reverse(x, ++i, --j);

        }

    }

    public static void print(int[] x){
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 9};
        Reverse_an_array r = new Reverse_an_array();
        r.reverseArray(arr);
        print(arr);
    }
}