package recursion;
import java.util.*;

public class Palindrome_Partitioning {

    // function for performing palindrome partioning
    public List<List<String>> palindromePartitioning(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0, s, path, res);
        return res;
    }

    // helper function for palindrome partitioning
    public static void helper(int index, String s, List<String> path, List<List<String>> res ){
        // Base Case
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); ++i){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                // recursive call
                helper(i+1, s, path, res);
                path.remove(path.remove(path.size()-1));
            }
        }
    }

    // function to check whether string is palindrome or not
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "10001";
        Palindrome_Partitioning p = new Palindrome_Partitioning();
        p.palindromePartitioning(s);
    }
}