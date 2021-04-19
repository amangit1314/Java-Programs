package bit_manipulation;

import java.io.*;

public class Count_set_bit_in_integer {
    /*
     * Function to get no of set bits in binary representation of positive integer n
     */
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = 9;
        System.out.println(countSetBits(i));
    }
}
