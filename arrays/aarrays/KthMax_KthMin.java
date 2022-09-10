package arrays.aarrays;

import java.util.Arrays;

public class KthMax_KthMin {

    public static int findMedian(int[] a, int n, int i){
        if(i <= n) {
            Arrays.sort(a, i, n);
        }else {
            Arrays.sort(a, n, i);
        }
        return a[n/2];
    }

    public static int kthSmallest(int[] a, int l, int r, int k){
        if(k > 0 && k <= r-l+1){
            int n = r-l+1;
            int i;
            int[] median = new int[(n + 4) / 5];
            for (i = 0; i < n/5; i++)
                median[i] = findMedian(a,l + i * 5, 5);

            if (i*5 < n) {
                median[i] = findMedian(a,l + i * 5, n % 5);
                i++;
            }

            int medOfMed = (i == 1)? median[i - 1]:
                    kthSmallest(median, 0, i - 1, i / 2);

            int pos = partition(a, l, r, medOfMed);

            if (pos-l == k - 1)
                return a[pos];

            if (pos-l > k - 1)
                return kthSmallest(a, l, pos - 1, k);

            return kthSmallest(a, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int l, int r, int x) {
        int i;
        for (i = l; i < r; i++)
            if (arr[i] == x) 	break;
        swap(arr, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] a = {12, 3, 5, 7, 4, 19, 26};
        int n = a.length, k = 3;
        System.out.println("K^th smallest element is " + kthSmallest(a, 0, n - 1, k));
    }
}