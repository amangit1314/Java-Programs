package strings;

import java.util.ArrayList;
import java.util.List;

// Recursively print all sentences that can be formed from list of word lists
public class Problem_43 {
    public static void printSentences(List<List<String>> wordLists) {
        printSentencesHelper(wordLists, new ArrayList<>(), 0);
    }

    private static void printSentencesHelper(List<List<String>> wordLists, List<String> currentSentence, int level) {
        // Base case: reached the end of the word lists
        if (level == wordLists.size()) {
            // Print the complete sentence
            System.out.println(String.join(" ", currentSentence));
            return;
        }

        // Get the list of words for the current level
        List<String> words = wordLists.get(level);

        // Loop through each word in the current list
        for (String word : words) {
            // Add the word to the current sentence
            currentSentence.add(word);
            // Recursively explore sentences starting from the next level
            printSentencesHelper(wordLists, currentSentence, level + 1);
            // Backtrack: remove the added word after recursion
            currentSentence.remove(currentSentence.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<String>> wordLists = new ArrayList<>();
        wordLists.add(List.of("love", "like"));
        wordLists.add(List.of("dogs", "cats"));
        wordLists.add(List.of("are", "a"));

        System.out.println("All possible sentences:");
        printSentences(wordLists);
    }
}
