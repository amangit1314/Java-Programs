package backtracking;

public class Palindrome_String {
    boolean isPalindrome(String s, int l, int r){
        if(l >= r)
            return true;

        if(s.charAt(l) != s.charAt(r))
            return false;

        return isPalindrome(s,l+1, r-1);
    }
    public static void main(String[] args) {

    }
}