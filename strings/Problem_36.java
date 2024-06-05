package strings;
// Given a sequence of words, print all anagrams together

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem_36 {

  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> anagramMap = new HashMap<>();

    for (String word : strs) {
      // Sort the characters of the word (anagrams have the same sorted characters)
      char[] charArray = word.toCharArray();
      Arrays.sort(charArray);
      String sortedWord = new String(charArray);

      // Add the word to the list of anagrams for its sorted form (key) in the HashMap
      anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
      anagramMap.get(sortedWord).add(word);
    }

    // Convert the HashMap values (lists of anagrams) to a List of Lists for the output
    return new ArrayList<>(anagramMap.values());
  }

  public static void main(String[] args) {
    String[] words = {"act", "god", "cat", "dog", "tac"};
    List<List<String>> anagramGroups = groupAnagrams(words);

    System.out.println("Anagram groups:");
    for (List<String> group : anagramGroups) {
      System.out.println(group);
    }
  }
}
