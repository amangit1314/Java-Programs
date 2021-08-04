package arrays;

import java.io.*;

//Array Implementation using try-catch & Buffers
public class ArrayLevel2 {

	public static void main(String[] args) {
		
		int a[];
		a = new int[5];
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for(int i=0;i<5;i++) {
				int j=i+1;
				System.out.println(" Enter element no." +j);
				String s = br.readLine();
				a[i] = Integer.parseInt(s);
			}
			for(int i=0;i<5;i++) {
			System.out.println("arr["+i+"]="+a[i]);
			}
		}
		
		catch(Exception e) {
			System.out.println(""+e);
		}
	}
}
		
		


