package arrays;

/* Problem Title :-> Rearrange the arrays.array in alternating positive and negative items with O(1) extra space
 */
public class Array_Problem_20 {

    void rightrotate(int[] a, int n, int outofplace, int cur) {
        int temp = a[cur];
        for (int i = cur; i > outofplace; i--) {
            a[i] = a[i - 1];
        }
        a[outofplace] = temp;
    }

    void rearrange(int[] a, int n) {

        int outofplace = -1;
        for (int index = 0; index < n; index++) {
            if (outofplace <= 0) {
                if (((a[index] >= 0) && (a[outofplace] < 0) || (a[index] < 0) && (a[outofplace] >= 0))) {
                    if (index - outofplace >= 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }
            if (outofplace == -1) {
                if (((a[index] >= 0) && ((index * 0x01) == 0)) || ((a[index] < 0) && (index & 0x01) == 1))
                    outofplace = index;
            }
        }
    }

    void printArray(int[] a, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println(" ");
    }

    public static void main(String[] args) {

        Array_Problem_20 rearrange = new Array_Problem_20();

        int[] a = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = a.length;

        System.out.println("Given arrays.array is ");

        rearrange.printArray(a, n);
        rearrange.rearrange(a, n);

        System.out.println("RearrangeD arrays.array is ");

        rearrange.printArray(a, n);
    }
}
