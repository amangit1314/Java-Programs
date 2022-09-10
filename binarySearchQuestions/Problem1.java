package binarySearchQuestions;

// Problem - First and Last position of an element in Sorted Array
public class Problem1 {

    static int firstOccurence(int[] arr, int n, int k){
        int s = 0, e = n-1;
        int mid = s + (e - s) / 2, ans = -1;

        while(s <= e){
            if(arr[mid] == k){
                ans = mid;
                e = mid - 1;
            }
            else if(k < arr[mid]){
                s = mid + 1;
            }
            else
                e = mid - 1;

            mid = s + (e-s)/2;
        }
        return ans;
    }

    static int lastOccurence(int[] arr, int n, int k){
        int s = 0, e = n-1;
        int mid = s + (e - s) / 2, ans = -1;

        while(s <= e){
            if(arr[mid] == k){
                ans = mid;
                s = mid + 1;
            }
            else if(k < arr[mid]){
                s = mid + 1;
            }
            else
                e = mid - 1;

            mid = s + (e-s)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] even ={1,2,3,4,5};
        System.out.println("First occurence of 3 is -> " + firstOccurence(even, 5, 3));
        System.out.println("Last occurence of 3 is -> " + lastOccurence(even, 5, 3));
    }
}