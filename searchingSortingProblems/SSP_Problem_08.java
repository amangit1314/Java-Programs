package searchingSortingProblems;

// Problem Title => Majority Element
public class SSP_Problem_08 {

    void printMajority(int[] a, int size) {
        int cand = findCandidate(a, size);
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }
    
    int findCandidate(int[] a, int size) {
        int maj_idx = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_idx] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_idx = i;
                count = 1;
            }
        }
        return a[maj_idx];
    }

    boolean isMajority(int[] a, int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        return count > size / 2;
    }
    public static void main(String[] args) {
        SSP_Problem_08 majorelement = new SSP_Problem_08();
        int[] a = new int[] { 1, 3, 3, 1, 2 };

        // Function call
        int size = a.length;
        majorelement.printMajority(a, size);
    }
}
