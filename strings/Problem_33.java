package strings;

import java.util.HashMap;

public class Problem_33 {

    public static String findMinWindow(String s, String t) {
      if (s == null || t == null || t.isEmpty()) {
        return "";
      }
  
      // Count occurrences of each character in the target string
      HashMap<Character, Integer> charCount = new HashMap<>();
      for (char c : t.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
      }
  
      // Initialize variables for tracking the window
      int windowStart = 0, minWindowLength = Integer.MAX_VALUE, count = 0;
  
      // Slide the window across the string
      for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        char endChar = s.charAt(windowEnd);
  
        // If the character is in the target string, increment the count
        if (charCount.containsKey(endChar)) {
          charCount.put(endChar, charCount.get(endChar) - 1);
          if (charCount.get(endChar) >= 0) {
            count++; // Found a character needed by the target string
          }
        }
  
        // Shrink the window if all characters from the target string are found
        while (count == t.length()) {
          int currentWindowLength = windowEnd - windowStart + 1;
          if (currentWindowLength < minWindowLength) {
            minWindowLength = currentWindowLength;
            // Update the window to reflect the smallest valid window so far
          }
  
          char startChar = s.charAt(windowStart);
          if (charCount.containsKey(startChar)) {
            if (charCount.get(startChar) == 0) {
              count--; // Lost a character needed by the target string
            }
            charCount.put(startChar, charCount.get(startChar) + 1);
          }
          windowStart++;
        }
      }
  
      // Return the smallest window if found, otherwise an empty string
      return minWindowLength != Integer.MAX_VALUE ? s.substring(windowStart, windowStart + minWindowLength) : "";
    }
  
    public static void main(String[] args) {
      String s = "ADOBECODEBANC";
      String t = "ABC";
      String smallestWindow = findMinWindow(s, t);
      System.out.println("Smallest window containing all characters of '" + t + "' in '" + s + "' is: " + smallestWindow);
    }
  }
  