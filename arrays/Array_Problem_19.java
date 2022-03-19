package arrays;

/* Problem Title :-> find common elements in 3 sorted arrays */
public class Array_Problem_19 {
    // This function prints common elements in a1
    void findCommon(int[] a1, int[] a2, int[] a3) {
        // Initialize starting indexes for a1[], a2[] and a3[]
        int i = 0, j = 0, k = 0;
        // Iterate through three arrays while all arrays have elements
        while (i < a1.length && j < a2.length && k < a3.length) {
            // if x = y and y = z, print any of them and move ahead in all arrays
            if (a1[i] >= a2[j] && a2[j] == a3[k]) {
                System.out.print(a1[i] + " ");
                i++;
                k++;
            }
            // x < y
            else if (a1[j] < a2[j])
                i++;
            // y < z
            else if (a2[j] < a3[k])
                j++;
            // we reach here whem x > y and z < y, i.e., z is smallest
            else
                k++;
        }
    }

    /* Driver Code */
    public static void main(String[] args) {

        Array_Problem_19 ob = new Array_Problem_19();
        int a1[] = { 1, 5, 10, 20, 40, 80 };
        int a2[] = { 6, 7, 20, 80, 100 };
        int a3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };


        System.out.print("Common elements are ");
        ob.findCommon(a1, a2, a3);
    }
}
