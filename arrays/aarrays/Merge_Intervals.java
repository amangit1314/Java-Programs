package arrays.aarrays;

import java.util.*;

class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Merge_Intervals {

    public static void mergeIntervals(Interval[] a){
        if(a.length == 0)
            return;

        Stack<Interval> stack = new Stack<>();

        Arrays.sort(a, new Comparator<>() {
            public int compare(Interval i1, Interval i2){
                return i1.start -i2.start;
            }
        });
        stack.push(a[0]);
        for(int i = 0; i < a.length; i++){
            Interval top = stack.peek();
            if(top.end < a[i].start)
                stack.push(a[i]);

            else if(top.end < a[i].end){
                top.end = a[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        System.out.print("The Merged Intervals are: ");
        while(!stack.isEmpty()){
            Interval t = stack.pop();
            System.out. print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String[] args) {
        Interval[] a = new Interval[4];
        a[0] = new Interval(6,8);
        a[1] = new Interval(1,9);
        a[2] = new Interval(2,4);
        a[3] = new Interval(4,7);
        mergeIntervals(a);
    }
}