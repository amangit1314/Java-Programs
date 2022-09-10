package backtracking;
import java.util.*;

public class Print_all_Permutations_of_string {

    static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }

    void permute(String s, int l, int r){
        if(l == r){
            System.out.println(s);
            return;
        }
//        for(int i = l; i <= r; i++){
//            s = swap(s,l,i);
//            permute(s,l+1,r);
//            s=swap(s,l,i);
//        }
    }
    public static void main(String[] args) {

    }
}