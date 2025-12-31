package greedy;

// Find smallest number with given number of digits and sum of digits
public class Problem_33 {
    public static String smallestNumber(int numDigits, int sumDigits) {
        if (sumDigits == 0) {
            return numDigits == 1 ? "0" : "-1";
        }
        if (sumDigits > 9 * numDigits) {
            return "-1";
        }

        char[] result = new char[numDigits];
        for (int i = 0; i < numDigits; i++) {
            result[i] = '0';
        }

        sumDigits -= 1; // Reserve 1 for the most significant digit
        for (int i = numDigits - 1; i > 0; i--) {
            if (sumDigits > 9) {
                result[i] = '9';
                sumDigits -= 9;
            } else {
                result[i] = (char) ('0' + sumDigits);
                sumDigits = 0;
                break;
            }
        }
        result[0] = (char) ('1' + sumDigits); // Add the reserved 1

        return new String(result);
    }

    public static void main(String[] args) {
        int numDigits = 3;
        int sumDigits = 20;

        String result = smallestNumber(numDigits, sumDigits);
        System.out.println("Smallest number with " + numDigits + " digits and sum " + sumDigits + " is: " + result);
    }
}