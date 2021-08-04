package strings;
import java.util.Scanner;

// Problem Title => Write a Code to check whether one string is a rotation of another
public class Problem_5 {

    //function to check whether the strings are rotations or not
    static boolean areRotations(String str1, String str2){
        return (str1.length() == str2.length() && ((str1 + str2).contains(str2)));
    }
    //driver function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (areRotations(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.print("Strings are not rotations of each other");
    }
}