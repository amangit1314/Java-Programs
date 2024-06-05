package strings;

import java.util.HashMap;

// * Converting Roman Numerals to Decimal
public class Problem_26 {

    public static int convert(String romanNumeral) {
        int decimal = 0;
        int n = romanNumeral.length();

        // Map for Roman symbols and their corresponding decimal values
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < n; i++) {
            int current = map.get(romanNumeral.charAt(i));

            // Check for subtractive notation (IV, IX, XL, XC, CM)
            if (i + 1 < n && current < map.get(romanNumeral.charAt(i + 1))) {
                decimal += map.get(romanNumeral.charAt(i + 1)) - current;
                i++; // Skip the next character as it was used for subtraction
            } else {
                decimal += current;
            }
        }

        return decimal;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMIV";
        int decimal = convert(romanNumeral);

        System.out.println(romanNumeral + " in decimal is: " + decimal);
    }
}
