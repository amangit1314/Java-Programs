package strings;

//* Convert a Sentence into its equivalent mobile numeric keypad sequence.
public class Problem_20 {

    public static String convert(String sentence) {
        sentence = sentence.toUpperCase(); // Convert to uppercase for consistent mapping
        StringBuilder numberSequence = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                int digit = (c - 'A') / 3 + 2; // Map letter to corresponding number on keypad
                // Add extra press for letters on 7, 8, and 9
                if (digit == 8 || digit == 9) {
                    digit++;
                }
                numberSequence.append(digit);
            } else if (c == ' ') {
                numberSequence.append(0); // Add 0 for space
            }
            // Ignore other characters
        }

        return numberSequence.toString();
    }

    public static void main(String[] args) {
        String sentence = "Welcome to Coursewave!";
        String numberSequence = convert(sentence);
        System.out.println(sentence + " converted to: " + numberSequence);
    }
}

