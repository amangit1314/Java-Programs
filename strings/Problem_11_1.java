package strings;
import java.util.*;

// Problem Title => Print all Subsequences of a string.
public class Problem_11_1 {

    // Declare a global linkedList.list
    static List<String> al = new ArrayList<>();


    private static void findSubSequences(String s, String ans){
        if(s.length() == 0){
            al.add(ans);
            return;
        }
        // We add add-ing 1st character in string
        findSubSequences(s.substring(1), ans+s.charAt(0));

        // Not adding first character of the string because the concept of subsequence either character will present or not.
        findSubSequences(s.substring(1),ans);
    }



    // Creating a public static Arraylist such that we can store values
    // IF there is any question of returning then we can directly return too
    // public static ArrayList<String> al = new ArrayList<String>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        findSubSequences(s, "");
        System.out.println(al);
    }
}