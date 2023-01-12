
package arrays.interviewProblems;
import java.util.*;
// Website -> CodeStudio
// Problem Name -> Aggressive Cows
public class Aggressive_Cows
{
    public static boolean isPossible(ArrayList<Integer> stalls, int k, int mid) {
        int cowCount = 1;
        int lastPos = stalls.get(0);

        for(int i = 0; i < stalls.size(); i++) {
            if(stalls.get(i) - lastPos >= mid) {
                cowCount++;
                if(cowCount == k) {
                    return true;
                }
                lastPos = stalls.get(i);
            }
        }
        return false;
    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k)
    {
        //    Write your code here.
        Collections.sort(stalls);
        int start = 0, max = -1;

        for(int i = 0; i < stalls.size(); i++) {
            max = Math.max(max, stalls.get(i));
        }

        int end = max;
        int ans = -1;

        int mid = start + (end - start) / 2;
        while(start <= end) {
            if(isPossible(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            }

            else
                end = mid - 1;

            mid = start + (end - start) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}