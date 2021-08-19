package backtracking;
import java.util.*;

public class Word_Break_PUB {
	
	private static void backtrack(String sentence, String A, String sentence2, ArrayList<String> result) {
		
		if(A.length() == 0) {
			result.add(sentence);
			return;
		}
		
		for(int i = 0; i < A.length(); i++) {
			
			String substring = A.substring(0, i + 1);
			
			if(sentence2.contains(substring)) {
				String newSentence = sentence + " " + substring;
				backtrack(newSentence.trim(), A.substring( i + 1), sentence2, result);
			}
		}
	}
	
	public static ArrayList<String> wordBreak(String A, String sentence) {
		ArrayList<String> result = new ArrayList<>();
		backtrack("", A, sentence, result);
		return result;
	}
	
	public static void main(String[] args) {
		
		String sentence = "I Like mango icecream and SamSung Mobile";
		String A = null;
		String[] result;
		String[] dictionary = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", 
				"icecream"};
		
		System.out.println(wordBreak(A,sentence));
	}

}
