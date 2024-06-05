public class Sum_Array {
    public static void sum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length - 1; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sum(array);
    }
}