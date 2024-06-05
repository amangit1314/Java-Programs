public class Filter {

    public static void filterdArray(int[] arr) {
        //! filtering process
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] % 2 != 0)
                System.out.print(arr[i] + " ");
        }
    }

    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        filterdArray(arr);
    }
}