package recursion;

//Program to Find the Subsequences of Given String by using RECURSION
public class Subsequences {
	
	public static String[] findSubsequences(String str) {
		
		if(str.length() == 0) {
			String ans[] = {""};
			return ans;
		}
		
		String smallAns[] = findSubsequences(str.substring(1));
		String ans[] = new String[2 * smallAns.length];
		
		/*
		 * Otherwise:
		 * int k = 0;
		 */
		for(int i = 0 ; i < smallAns.length ; i++) {
			ans[i] = smallAns[i];
			/*
			 * Otherwise: 
			 * ans[k] = smallAns[i];
			 * k++;
			 */
		}
		
		for(int i = 0 ; i< smallAns.length ; i++) {
			/*
			 * otherwise: ans[k] in place of ans[i + smallAns] and
			 * k++;
			 */
			ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		String str = "xyz";
		String ans[] = findSubsequences(str);
		for(int i = 0 ; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
