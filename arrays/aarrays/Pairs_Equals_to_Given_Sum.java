package arrays.aarrays;

// Pair equals to a given number sum
public class Pairs_Equals_to_Given_Sum {

    static void pairs_value(int[] iA, int iN){
        System.out.println("Pairs of elements & their sum: ");
        for(int i =0; i < iA.length; i++){
            for(int j = i+1; j < iA.length; j++){
                if(iA[i]+iA[j] == iN){
                    System.out.println(iA[i] + " + " + iA[j] + " = " + iN);
                }
            }
        }
    }

    public static void main(String[] args) {
        pairs_value(new int[] {7,9,1,3,4,8,6}, 10);
//        pairs_value(new int[] {14,-15,9,16,25,45,12,8},30);
    }
}