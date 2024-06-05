package strings;

import java.util.HashMap;

// Check if two given strings are isomorphic to each other
public class Problem_42 {
    public static boolean isIsomorphic(String str1, String str2) {
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      return false; // Invalid input (strings must be of the same length)
    }

    // Create two HashMaps to store mappings between characters in str1 and str2
    HashMap<Character, Character> map1 = new HashMap<>();
    HashMap<Character, Character> map2 = new HashMap<>();

    for (int i = 0; i < str1.length(); i++) {
      char char1 = str1.charAt(i);
      char char2 = str2.charAt(i);

      // Check if the characters in str1 and str2 at the same index have already been mapped differently
      if (map1.containsKey(char1) && map1.get(char1) != char2) {
        return false;
      } else if (map2.containsKey(char2) && map2.get(char2) != char1) {
        return false;
      }

      // Add mappings to the HashMaps if not already present
      map1.put(char1, char2);
      map2.put(char2, char1);
    }

    return true;
  }

  public static void main(String[] args) {
    String str1 = "egg";
    String str2 = "add";
    boolean isIsomorphic = isIsomorphic(str1, str2);
    System.out.println("Strings '" + str1 + "' and '" + str2 + "' are isomorphic: " + isIsomorphic);
  }
}
