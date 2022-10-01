package backtracking;

public class Tug_of_War {

    public static int min_diff;

    public static void towUtil(int[] arr, int n, boolean[] curr_elements, int no_of_selected_elements, boolean[] solution, int sum, int curr_sum, int curr_position) {
        if(curr_position == n)
            return;

        if((n/2 - no_of_selected_elements) > (n - curr_position))
            return;

        towUtil(arr, n, curr_elements, no_of_selected_elements, solution, sum, curr_sum, curr_position + 1);
        no_of_selected_elements++;
        curr_sum = curr_sum + arr[curr_position];
        curr_elements[curr_position] = true;

        if (no_of_selected_elements == n/2) {
            if (Math.abs(sum/2 - curr_sum) < min_diff) {
                for(int i = 0; i < n; i++) {
                    solution[i] = curr_elements[i];
                }
            }
            else
                towUtil(arr, n, curr_elements, no_of_selected_elements, solution, sum, curr_sum, curr_position + 1);
        }
        curr_elements[curr_position] = false;
    }

    public void tugOfWar(int[] arr) {
        int n = arr.length;
        boolean[] curr_elements = new boolean[n];
        boolean[] solution = new boolean[n];
        min_diff = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            curr_elements[i] = solution[i] = false;
        }

        towUtil(arr, n, curr_elements, 0, solution, sum, 0, 0);

        for(int i = 0; i < n; i++) {
            if(!solution[i])
                System.out.println(arr[i] + " ");
        }

        for(int i = 0; i < n; i++) {
            if(solution[i])
                System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {



    }
}

// Time Complexity - O(2^n)
// Space Complexity - O(1)