package practice.arrays;

public class Count_Conversion {
    static int[] a = new int[] {1, 20, 30, 6, 4, 5};

    static int getConversion(int n){
        int inv_count = n;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(a[i] > a[j])
                    inv_count++;
            }
        }
        return inv_count;
    }
    public static void main(String[] args) {
        System.out.println("Number of inversions are " + getConversion(a.length));
    }
}