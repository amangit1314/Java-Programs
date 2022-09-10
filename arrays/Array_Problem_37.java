package arrays;
/* Problem Title :-> Median of 2 sorted arrays of different size */
public class Array_Problem_37 {
    static int getMedian(int[] a1, int[] a2, int n, int m) {

        //Current index of input arrays.array a1[]
        int i = 0;
        //Current index of input arrays.array a2[]
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;
        /*
         * Since there are (n + m) elements ,
         * There are following two cases :->
         * if n + m is odd then the middle index is median
         * i.e. (m + n)/2
         */
        if ((m + n) % 2 == 1){
            for (count = 0; count <= (n + m) / 2; count++){
                if(i != n && j != m){
                    m1 = (a1[i] > a2[j]) ? a2[j++] : a1[i++];
                }
                else if(i < n)
                    m1 = a1[i++];
                // for case when j < m.
                else
                    m1 = a2[j++];
            }
            return m1;
        }
        /*
        * median will be average of elements
        * at index (( m + n) / 2 - 1) and (m + n) / 2
        * in the arrays.array obtained after merging a1 and a2.
        */
        else{
            for (count = 0; count <= (n + m) / 2; count++){
                m2 = m1;
                if (i != n && j != m)
                    m1 = (a1[i] > a2[j]) ? a2[j++] : a1[i++];

                else if(i < n)
                    m1 = a1[i++];

                // for case when j < m.
                else
                    m1 = a2[j++];
            }
            return (m1 + m2) / 2;
        }
    }

    /* Driver program to test above function */
    public static void main(String[] args) {

        int[] a1 = {900};
        int[] a2 = {5, 8, 10, 20};

        int n1 = a1.length;
        int n2 = a2.length;

        System.out.println("Median is " + getMedian(a1, a2, n1, n2));

    }
}
