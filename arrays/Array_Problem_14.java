package arrays;

import java.util.*;

public class Array_Problem_14 {
    public static void mergeIntervals(Interval a[]) {
        if (a.length <= 0) {
            return;
        }

        Stack<Interval> stack = new Stack<>();
        Arrays.sort(a.new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        stack.push(a[0]);
    }

    public static void main(String[] args) {
        Interval a[] = new Interval[4];

    }
}

/**
 * Interval
 */
class Interval {

    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
