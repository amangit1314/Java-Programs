package backtracking;

public class Powerset_of_string {

    void powerSet(String s, int i, String curr) {
        if (i == s.length()){
            System.out.println(curr);
            return;
        }
        powerSet(s, i+1, curr+s.charAt(i));
        powerSet(s, i+1, curr);
    }

    public static void main(String[] args) {

    }
}