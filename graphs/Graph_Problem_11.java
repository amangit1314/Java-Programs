package graphs;
import java.util.*;

// Problem Title => Word ladder
public class Graph_Problem_11 {
    // Returns length of the shortest chain to reach 'target' from 'start' using minimum number of adjacent moves. D is dictionary
    static int shortestChainLen(String start, String target, Set<String> D) {

        if(Objects.equals(start, target))
            return 0;
        // If the target String is not present in the dictionary
        if (!D.contains(target))
            return 0;

        // To store the current chain length and the length of the words
        int level = 0, wordlength = start.length();

        // Push the starting word into the queue
        Queue<String> Q = new LinkedList<>();
        Q.add(start);

        // While the queue is non-empty
        while (!Q.isEmpty()) {

            // Increment the chain length
            ++level;

            // Current size of the queue
            int sizeofQ = Q.size();

            // Since the queue is being updated while it is being traversed so only the elements which were already present in the queue before the start of this loop will be traversed for now
            for (int i = 0; i < sizeofQ; ++i) {

                // Remove the first word from the queue
                assert Q.peek() != null;
                char []word = Q.peek().toCharArray();
                Q.remove();

                // For every character of the word
                for (int pos = 0; pos < wordlength; ++pos)
                {

                    // Retain the original character
                    // at the current position
                    char orig_char = word[pos];

                    // Replace the current character with
                    // every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c)
                    {
                        word[pos] = c;

                        // If the new word is equal
                        // to the target word
                        if (String.valueOf(word).equals(target))
                            return level + 1;

                        // Remove the word from the set
                        // if it is found in it
                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));

                        // And push the newly generated word
                        // which will be a part of the chain
                        Q.add(String.valueOf(word));
                    }

                    // Restore the original character
                    // at the current position
                    word[pos] = orig_char;
                }
            }
        }

        return 0;
    }

    // Driver code
    public static void main(String[] args)
    {
        // make dictionary
        Set<String> D = new HashSet<>();
        D.add("spoon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                + shortestChainLen(start, target, D));
    }
}