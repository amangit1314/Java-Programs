package matrix;
/*Rotate Matrix by 90 degrees*/

public class Matrix_Problem_08{
    static int N = 4;
    //Function to rotate the matrix 90 degree clockwise
    static void rotate90(int[][] a){
        //Traverse Each Cycle
        for(int i = 0; i < N/2; i++){
            for(int j = i; j < N - i - 1; j++){
                //Swap elements of each cycle in clockwise direction
                int temp = a[i][j];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 -i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    //Function for print matrix
    static void printMatrix(int[][] a){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(a[i][j] + " ");
                System.out.println();
            }
        }
    }

    //Drier Code
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        rotate90(a);
        printMatrix(a);
    }
}
