package arrays;
import java.util.*;

/* Problem Title :->  Merge Intervals */
public class Array_Problem_14 {
    //The main function that takes a set of intervals, merges overlapping intervals & prints the result.
    public static void mergeIntervals(Interval[] a){
        //Test if the given set has at least one interval
        if(a.length <= 0)
            return;
        //Create an empty stack of intervals
        Stack<Interval> stack = new Stack<>();
        //sort the intervals in increasing order of start time
        Arrays.sort(a, new Comparator<>() {
            public int compare(Interval i1, Interval i2){
                return i1.start -i2.start;
            }
        });
        //push the first interval to stack
        stack.push(a[0]);
        //Start from the next interval and merge if necessary
        for(int i = 1; i < a.length; i++){
            //get interval from stack top
            Interval top = stack.peek();
            //if current interval is not overlapping with stack top,push it to the stack
            if(top.end < a[i].start)
                stack.push(a[i]);
            //Otherwise update the ending time of top if ending of current interval is more
            else if(top.end < a[i].end){
                top.end = a[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        //Print contents of stack
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

class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
