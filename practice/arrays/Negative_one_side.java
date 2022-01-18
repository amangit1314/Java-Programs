package practice.arrays;

public class Negative_one_side {

    static void rearrange(int[] arr, int n){
        int shift = 0, temp;
        System.out.println("Iterations");
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){

                if(i!= shift){
                    temp = arr[i];
                    arr[i] = arr[shift];
                    arr[shift] = temp;
                    System.out.println();
                    printArray(arr, arr.length);
                }
                shift++;
            }
        }
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -5, 7, -9, 3, -4};
        int n = arr.length;
        System.out.println("Given array is -> ");
        printArray(arr, n);
        rearrange(arr, n);
        System.out.print("Rearranged array is -> \n");
        printArray(arr, n);
    }
}