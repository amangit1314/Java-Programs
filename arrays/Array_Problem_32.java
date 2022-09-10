package arrays;

/* Problem Title :->  find minimum number of operations to make an arrays.array palindrome */
public class Array_Problem_32 {

    static int findMinOps(int[] a, int n){
        int ans = 0;
        for(int i = 0, j = n-1; i <= j;){
            if(a[i] == a[j]){
                i++;
                j--;
            }
            else if(a[i] > a[j]){
                j--;
                a[j] += a[j+1];
                ans++;
            }
            else{
                i++;
                a[i] += a[i - 1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5, 9, 1};
        System.out.println("Count of minimum operations is" + findMinOps(a, a.length));
    }

}
