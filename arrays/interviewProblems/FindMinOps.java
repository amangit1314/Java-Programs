package arrays.interviewProblems;
/* Problem Title :-> Minimum no. of operations required to make an arrays.array palindrome */
// class Array_Problem_35 {
class FindMinOps {
    static int findMinOps(int[] a, int n) {

        //Initialize result
        int ans = 0;

        //Start from two corners
        for(int i=0,j=n-1;i<=j;) {

            if(a[i] == a[j]) {
                i++;
                j--;
            }else if(a[i] > a[j]) {
                j--;
                a[j] += a[j+1];
                ans++;
            }else {
                i++;
                a[i] += a[i-1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Count of minimum operations is " + findMinOps(a , a.length));
    }
}
