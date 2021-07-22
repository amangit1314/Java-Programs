package arrays;
/* Problem Title :->  Next Permutation */
public class Array_Problem_15 {

    public static boolean nextPermutation(int[] numbs){
        int mark = -1;
        for(int i = numbs.length - 1; i > 0; i--){
            if(numbs[i] > numbs[i - 1]){
                mark = i - 1;
                break;
            }
        }
        if (mark == -1){
            reverse(numbs, 0, numbs.length-1);
            return false;
        }
        int idx = numbs.length - 1;
        for (int i = numbs.length-1; i >= mark + 1; i--){
            if(numbs[i] > numbs[mark]){
                idx = i;
                break;
            }
        }
        swap(numbs, mark, idx);
        reverse(numbs, mark + 1, numbs.length - 1);
        return true;
    }

    private static void swap(int[] numbs, int i, int j){
        int t = numbs[i];
        numbs[i] = numbs[j];
        numbs[j] = t;
    }

    private static void reverse(int[] numbs, int i, int j){
        while(i < j){
            swap(numbs, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] numbs = new int[]{2, 3, 5, 7, 9, 4};
        System.out.print(nextPermutation(numbs));
    }
}
