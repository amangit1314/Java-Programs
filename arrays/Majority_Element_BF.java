package arrays;
// Find the majority element in java, Brute Force Approach
public class Majority_Element_BF {
    static void findMajority(int[] a, int n){
        int maxCount = 0;
        int index = -1;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(a[i] == a[j])
                    count ++;
            }
            if(count > maxCount){
                maxCount = count;
                index = i;
            }
        }
        if (maxCount > n / 2)
            System.out.println(a[index]);

        else
            System.out.println("No Majority Element");
    }

    // Driver Function
    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 1, 3, 5, 1 };
        int n = a.length;

        // Function calling
        findMajority(a, n);
    }
}