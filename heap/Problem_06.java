package heap;

import java.util.Arrays;

// Problem Title => Merge K sorted Array's given in form of Matrix[n*n]
public class Problem_06 {

    static void merge(int[][] mat, int k, int[] temp){
        int i,j,t=0;
        for(i = 0; i < k; i++){
            for(j = 0; j < 4; j++){
                temp[t++] = mat[i][j];
            }
        }
    }

    public static void main(String[] args) {
        //n= no of elements in each arrays.array
        //k=no of arrays
        int n = 4;
        int k = 4;
        int[][] mat = {
            {1, 7, 9 ,3},
            {4, 2, 9, 1},
            {5, 4, 9, 8},
            {7, 3, 4, 1}
        };
        int[] temp = new int[n*k];
        merge(mat,k,temp);

        Arrays.sort(temp);
        for(int i=0; i<(n*k);i++)
            System.out.print(temp[i] + " ");
    }
}