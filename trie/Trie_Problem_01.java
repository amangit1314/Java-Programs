package trie;

public class Trie_Problem_01 {
	// Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
      
    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
       
        // isEndOfWord is true if the node represents end of a word
        boolean isEndOfWord;
          
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root; 
      
    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
    static void insert(String key){
        int length = key.length();
        TrieNode pCrawl = root;
       
        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            /// if is null then (TrieNode us position m dal do)
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            /// nhi to pCrawl = index wala pCrawl.children[] element ho jayega
            pCrawl = pCrawl.children[index];
        }
       
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
       
    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int length = key.length();
        TrieNode pCrawl = root;
       
        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
       
        return (pCrawl != null && pCrawl.isEndOfWord);
    }
       
    // Driver
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String[] output = {"Not present in trie", "Present in trie"};

        root = new TrieNode();
       
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
       
        // Search for different keys
        if(search("the"))
            System.out.println("the --- " + output[1]);

        else System.out.println("the --- " + output[0]);
          
        if(search("these"))
            System.out.println("these --- " + output[1]);

        else System.out.println("these --- " + output[0]);
          
        if(search("their"))
            System.out.println("their --- " + output[1]);

        else System.out.println("their --- " + output[0]);
          
        if(search("thaw"))
            System.out.println("thaw --- " + output[1]);

        else System.out.println("thaw --- " + output[0]);
    }
}
