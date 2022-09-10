package arrays.aarrays;
import java.util.*;

//Longest Consiquitive subarray
public class Longest_Consiqutive_subsequence {

    public static int findLongestSeq(int[] a, int n){
        Arrays.sort(a);
        int ans = 0, count = 0;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);

        for(int i = 1; i < n; i++){
            if(a[i] != a[i-1])  al.add(a[i]);
        }

        for(int i = 0; i < al.size(); i++){
            if(i > 0 && al.get(i) == al.get(i-1)+1) count++;
            else count = 1;
            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,9,3,10,4,20,2};
        int n=a.length;
        System.out.println("length of the longest " + "contiguous subsequence is " + findLongestSeq(a, n));
    }
}