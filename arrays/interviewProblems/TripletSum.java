package arrays.interviewProblems;

public class TripletSum {
    static boolean isSubSet(int[] a1, int[] a2, int m, int n) {
        int i = 0, j = 0;
        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(a2[i] == a1[j])	break;
                if(j == m)	return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[] a1 = {11, 1, 13, 21, 3, 7};
        int[] a2 = {11, 3, 7, 1};
        int m = a1.length;
        int n = a2.length;

        if(isSubSet(a1, a2, m, n))
            System.out.println("a2[] is " + "subset of a1[] ");
        else
            System.out.println("a2 is " + "not a subset of a1[]");
    }
}