package strings;
import java.util.*;

// Problem Title => Print all Subsequences of a string.
public class Problem_11_2 {

    //Set to store all the subsequences
    static HashSet<String> st = new HashSet<>();

    static void subSequence(String str){
        int n = str.length();
        for(int i = 0; i < n; i++){
            for(int j = n; j > i; j--){
                String sub_str = str.substring(i, j);

                st.add(sub_str);

                // Drop kth character in the substring and if it is not in the set then recur
                for (int k = 1; k < sub_str.length() - 1; k++) {
                    StringBuilder sb = new StringBuilder(sub_str);

                    // Drop character from the string
                    sb.deleteCharAt(k);
                    subSequence(sb.toString());
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        subSequence(s);
        System.out.println(st);
    }
}