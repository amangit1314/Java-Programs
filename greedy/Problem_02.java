package greedy;

import java.util.*;

// Problem Title => Job Sequencing Problem
public class Problem_02 {

    char id;
    int deadline, profit;

    public Problem_02(){}

    public Problem_02(char id, int profit, int deadline){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    void printJobScheduling(ArrayList<Problem_02> arr, int t){
        int n = arr.size();

        Collections.sort(arr, (a,b) -> b.profit - a.profit);
        boolean result[] = new boolean[t];
        char job[] = new char[t];

        for(int i = 0; i < n; i++){
            for(int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--){
                if(result[j] == false){
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
        for(char jb : job)
            System.out.print(jb + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<Problem_02> arr = new ArrayList<Problem_02>();

        arr.add(new Problem_02('a', 2, 100));
        arr.add(new Problem_02('b', 1, 19));
        arr.add(new Problem_02('c', 2, 27));
        arr.add(new Problem_02('d', 1, 25));
        arr.add(new Problem_02('e', 3, 15));

        // Function call
        System.out.println("Following is maximum " + "profit sequence of jobs");

        Problem_02 job = new Problem_02();

        // Calling function
        job.printJobScheduling(arr, 3);
    }
}
