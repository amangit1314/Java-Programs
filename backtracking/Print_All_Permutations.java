package backtracking;
import java.util.*;

// Problem Title => Print all permutations of string
public class Print_All_Permutations{

    // Swap characters at position
    // @param a string value
    // @param i position 1
    // @param j position 2
    // @return swapped string
    public String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return  String.valueOf(charArray);
    }

    // permutation function
    // @param str string to calculate permutation for
    // @param 1 starting index
    // @param r and index
    private void permute(String str, int l, int r){
        if(l == r)
            System.out.println(str);

        else{
            for(int i = 1; i <= r; i++){
                str = swap(str, l, i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    // Driver Function
    public static void main(String[] args) {
        // scanner object for talking inputs
        Scanner sc = new Scanner(System.in);

        // Asking user for String str as input
        String str = sc.nextLine();
        int n = str.length();

        // Making an object of Print_All_Permutations class
        Print_All_Permutations permutation = new Print_All_Permutations();

        // Permute the arrays.array or printing the permutation's
        permutation.permute(str, 0, n-1);
    }
}