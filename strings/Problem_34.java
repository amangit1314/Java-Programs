package strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem_34 {
    public static String rearrangeString(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Empty string has no characters to rearrange
        }

        // Count character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue to store characters based on their frequencies
        // (highest frequency first)
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        pq.addAll(charCount.keySet());

        // Characters to be used in the rearranged string
        StringBuilder result = new StringBuilder();

        // Previous character used (initialize with a special character not present in
        // the string)
        char prev = '#';

        while (!pq.isEmpty()) {
            char curr = pq.poll();

            // Check if the previous character is the same, skip if so (to avoid adjacent
            // duplicates)
            if (curr == prev) {
                if (pq.isEmpty()) {
                    return ""; // Not possible to rearrange without adjacent duplicates
                }
                char temp = pq.poll(); // Get the next character and put the current one back for later processing
                pq.offer(curr);
                curr = temp;
            }

            // Add the current character to the result and update the previous character
            result.append(curr);
            charCount.put(curr, charCount.get(curr) - 1); // Decrement frequency

            // If the frequency of the current character is not zero (can be used again
            // later), add it back to the queue
            if (charCount.get(curr) > 0) {
                pq.offer(curr);
            }

            prev = curr;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aab";
        String rearrangedString = rearrangeString(str);
        System.out.println("Rearranged string without adjacent duplicates: " + rearrangedString);
    }
}
