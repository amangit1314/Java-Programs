package stack_and_queue;
import java.util.*;

// Merge Overlapping Intervals

public class P16 {

    public static int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (a,b) );
        ArrayList<int[]> res = new ArrayList<>();

        if(res.size() == 0 || intervals == null) {
            res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end  = intervals[0][1];

        for(int[] a: intervals) {
                int[] prev = res.get(res.size() - 1);
                if(a[0] <= prev[1])
                    res.get(res.size() - 1)[1] = Math.max(a[1], prev[1]);
                else {
                    res.add(a);
                    start = prev[0];
                    end = prev[1];
                }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
//        int n = res.size();
//        int[][] arr = new int[n][2];
//        int idx = 0;
//        for(int[] a: res) {
//            arr[idx][0] = a[0];
//            arr[idx][1] = a[1];
//            idx++;
//        }
//        return arr;
    }

    public static void main(String[] args) {

    }
}