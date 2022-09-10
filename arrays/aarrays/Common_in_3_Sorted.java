package arrays.aarrays;

// Problem Title |<>--<>| Find Common in 3 Sorted Arrays
public class Common_in_3_Sorted {

    void findCommon(int[] a1, int[] a2, int[] a3){
        int i=0, j=0, k=0;

        while (i < a1.length && j < a2.length && k < a3.length){

            if(a1[i] >= a2[j] && a2[j] == a3[k]){
                System.out.print(a1[i] + " ");
                i++;
                k++;
            }

            else if(a1[j] < a2[j]){
                i++;
            }

            else if(a2[j] == a3[j]){
                j++;
            }

            else{
              k++;
            }
        }
    }
    public static void main(String[] args) {
        int[] a1 = {3,4,6,8,9,14,17,19};
        int[] a2 = {2,4,7,8,11,15,17,18};
        int[] a3 = {7,4,9,8,11,17,19,21};
        Common_in_3_Sorted c = new Common_in_3_Sorted();
        c.findCommon(a1, a2, a3);

    }
}