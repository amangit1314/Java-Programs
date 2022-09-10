package trie;

import java.util.Arrays;
import java.util.Comparator;
public class Trie_Problem_04 {
	// class for each word of duplicate arrays.array
	static class Word {
		String str; // to store word itself
		int index; // index of the word in the
		// original arrays.array

		// constructor
		Word(String str, int index)
		{
			this.str = str;
			this.index = index;
		}
	}

	// class to represent duplicate arrays.array.
	static class DupArray {
		Word[] array; // Array of words
		int size; // Size of arrays.array

		// constructor
		public DupArray(String str[], int size)
		{
			this.size = size;
			array = new Word[size];

			// One by one copy words from the
			// given wordArray to dupArray
			int i;
			for (i = 0; i < size; ++i) {
				// create a word Object with the
				// str[i] as str and index as i
				array[i] = new Word(str[i], i);
			}
		}
	}

	// Compare two words. Used in Arrays.sort() for
	// sorting an arrays.array of words
	static class compStr implements Comparator<Word> {
		public int compare(Word a, Word b)
		{
			return a.str.compareTo(b.str);
		}
	}

	// Given a linkedList.list of words in wordArr[],
	static void printAnagramsTogether(String wordArr[],
									int size)
	{
		// Step 1: Create a copy of all words present
		// in given wordArr. The copy will also have
		// original indexes of words
		DupArray dupArray = new DupArray(wordArr, size);

		// Step 2: Iterate through all words in
		// dupArray and sort individual words.
		int i;
		for (i = 0; i < size; ++i) {
			char[] char_arr = dupArray.array[i].str.toCharArray();
			Arrays.sort(char_arr);
			dupArray.array[i].str = new String(char_arr);
		}

		// Step 3: Now sort the arrays.array of words in
		// dupArray
		Arrays.sort(dupArray.array, new compStr());

		// Step 4: Now all words in dupArray are together,
		// but these words are changed. Use the index
		// member of word struct to get the corresponding
		// original word
		for (i = 0; i < size; ++i)
			System.out.print(wordArr[dupArray.array[i].index] + " ");
	}

	// Driver program to test above functions
	public static void main(String args[])
	{
		String wordArr[] = { "cat", "dog", "tac", "god", "act" };
		int size = wordArr.length;
		printAnagramsTogether(wordArr, size);
	}
}
// This code is contributed by Sumit Ghosh
