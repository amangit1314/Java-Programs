package bit_manipulation;
// Set Bits in Java
public class Set_Bits {

    static int countBits(int n){
        int count = 0;
        while(n > 0){
            // & operation [ {1 cross 1 = 1} otherwise result will be zero ]
            count = count + (n & 1);
            // >> used for right shift bit by one
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = 9;
        System.out.println(countBits(i));
    }
}