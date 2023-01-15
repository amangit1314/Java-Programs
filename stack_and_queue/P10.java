// The celebrity Problem
package stack_and_queue;

public class P10 {

    public static int celebrity(int[][] m, int n) {
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(m[count][i] == 1)
                count = i;
        }

        for(int i = 0; i < n; i++) {
            if(i != count && (m[count][i] == 1 || m[i][count] == 0))
                return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(celebrity(matrix, matrix.length));
    }
}