package arrays.aarrays;
// Min no of operations to make an arrays.array palindrome
public class Min_Palindrome_Operations {

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

    }
}