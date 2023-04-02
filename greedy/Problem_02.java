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

    void printJobScheduling(ArrayList<Problem_02> arr){

        arr.sort((a, b) -> b.profit - a.profit);
        boolean[] result = new boolean[3];
        char[] job = new char[3];

        for (Problem_02 problem_02 : arr) {
            for (int j = Math.min(3 - 1, problem_02.deadline - 1); j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    job[j] = problem_02.id;
                    break;
                }
            }
        }
        for(char jb : job)
            System.out.print(jb + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Problem_02> arr = new ArrayList<>();

        arr.add(new Problem_02('a', 2, 100));
        arr.add(new Problem_02('b', 1, 19));
        arr.add(new Problem_02('c', 2, 27));
        arr.add(new Problem_02('d', 1, 25));
        arr.add(new Problem_02('e', 3, 15));

        // Function call
        System.out.println("Following is maximum " + "profit sequence of jobs");

        Problem_02 job = new Problem_02();

        // Calling function
        job.printJobScheduling(arr);
    }
}
