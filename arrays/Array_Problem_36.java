package arrays;
/* Problem Title :-> Median of 2 sorted arrays of equal size */
public class Array_Problem_36 {

    //function to calculate median
    static int getMedian(int[] a1, int[] a2, int n) {

        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        /* Since there are 2n elements ,
         * median will be average of elements at index n-1
         * & n in the arrays.array obtained after merging a1[] & a2[]*/

        for(count = 0; count <= n; count++) {

            /* Below is to handle case where all elements of a1[] are
             * smaller than smallest(or first) element of a2[] */
            if(i == n) {
                m1 = m2;
                m2 = a2[0];
                break;
            }

            /* Below is to handle case where all elements of a2[]
             * are smaller than smaller than
             * smallest(or first) element of a1[]*/
            else if(j == n) {
                m1 = m2;
                m2 = a1[0];
                break;
            }

            /* equals sign because if two arrays have some common elements*/
            if(a1[i] <= a2[j]) {
                /* Store the previous median */
                m1 = m2;
                m2 = a1[i];
                i++;
            }

            else {
                /* Store the previous median */
                m1 = m2;
                m2 = a2[j];
                j++;
            }
        }

        return (m1 + m2)/2;
    }

    /* Driver program to test above function */
    @SuppressWarnings("unused")
	public static void main(String[] args) {

        int[] a1 = {1, 12, 15, 26, 38};
        int[] a2 = {2, 13, 17, 30, 45};

        int n1 = a1.length, n2 = a2.length;

        System.out.println("Median is " + getMedian(a1, a2, n1));

    }
}
