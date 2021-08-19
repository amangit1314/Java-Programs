package matrix;

import java.util.*;

// Problem Title => Common elements in all rows of a given matrix
public class Matrix_Problem_10 {
    // Specify number of rows and columns
    static int M = 4;
    static int N =5;

    // prints common element in all rows of matrix
    static void printCommonElements(int[][] mat) {

        Map<Integer,Integer> mp = new HashMap<>();

        // initialize 1st row elements with value 1
        for (int j = 0; j < N; j++)
            mp.put(mat[0][j],1);

        // traverse the matrix
        for (int i = 1; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // If element is present in the map and
                // is not duplicated in current row.
                if (mp.get(mat[i][j]) != null && mp.get(mat[i][j]) == i)
                {
                    // we increment count of the element
                    // in map by 1
                    mp.put(mat[i][j], i + 1);

                    // If this is last row
                    if (i == M - 1)
                        System.out.print(mat[i][j] + " ");
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };

        printCommonElements(mat);
    }
}