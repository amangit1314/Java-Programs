package arrays.array;
import java.util.*;

// TITLE => Merge Intervals.

class Intervel{
    int start, end;
    Intervel(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Problem14{
    public static void mergeIntervals(Intervel[] a){
        //Test if the given set has at least one interval
        if(a.length <= 0)
            return;

        //Create an empty stack of intervals
        Stack<Intervel> stack = new Stack<>();

        //sort the intervals in increasing order of start time
        Arrays.sort(a, Comparator.comparingInt(i -> i.start));

        //push the first interval to stack
        stack.push(a[0]);

        //Start from the next interval and merge if necessary
        for(int i = 1; i < a.length; i++){
            //get interval from stack top
            Intervel top = stack.peek();

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
            Intervel t = stack.pop();
            System.out. print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Intervel[] a = new Intervel[n];
        a[0] = new Intervel(6,8);
        a[1] = new Intervel(1,9);
        a[2] = new Intervel(2,4);
        a[3] = new Intervel(4,7);
        mergeIntervals(a);
    }
}