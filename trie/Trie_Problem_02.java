package trie;
/*
 * Problem Title :-Find shortest unique prefix for every word in a given linkedList.list
 */
public class Trie_Problem_02 {

	static final int MAX  = 256;
    
    // Maximum length of an input word
    static final int MAX_WORD_LEN = 500;
       
    // Trie Node.
    static class TrieNode
    {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency
        TrieNode() {
            freq =1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }
    static TrieNode root;
      
    // Method to insert a new string into Trie
    static void insert(String str)
    {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;
       
        // Traversing over the length of given str.
        for (int level = 0; level<len; level++)
        {
            // Get index of child node from current character
            // in str.
            int index = str.charAt(level);
       
            // Create a new child if not exist already
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
               (pCrawl.child[index].freq)++;
       
            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }
       
    // This function prints unique prefix for every word stored
    // in Trie. Prefixes one by one are stored in prefix[].
    // 'ind' is current index of prefix[]
    static void findPrefixesUtil(TrieNode root, char[] prefix,
                          int ind)
    {
        // Corner case
        if (root == null)
           return;
       
        // Base case
        if (root.freq == 1)
        {
           prefix[ind] = '\0';
           int i = 0;
           while(prefix[i] != '\0')
            System.out.print(prefix[i++]);
           System.out.print("  ");
           return;
        }
       
        for (int i=0; i<MAX; i++)
        {
           if (root.child[i] != null)
           {
               prefix[ind] = (char) i;
               findPrefixesUtil(root.child[i], prefix, ind+1);
           }
        }
    }
       
    // Function to print all prefixes that uniquely
    // represent all words in arr[0..n-1]
    static void findPrefixes(String arr[], int n)
    {
        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i<n; i++)
            insert(arr[i]);
       
        // Create an arrays.array to store all prefixes
        char[] prefix = new char[MAX_WORD_LEN];
          
        // Print all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0);
    }
       
    // Driver function.
    public static void main(String args[])
    {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        int n = arr.length;
        findPrefixes(arr, n);
    }

}
