package arrays.aarrays;
// Count Inversion
public class Count_Inversion {
    static int[] a = new int[] {10, 20, 30, 4, 50};

    static int getInvCount(int n){
        int inv_count = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j <= n; j++){
                if(a[i] > a[j]){
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        System.out.println("Number of inversions are: " + getInvCount(a.length));
    }
}