package arrays;
import java.util.*;

//Java Program for First Repeating Element
public class FRE {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) 
			a[i] = sc.nextInt();
		
	    int N = (int) (1e6+2); 
	    
	    //Array Input in Java
	    int idx[] = new int[N];
	    for (int  i = 0; i < N; i++)
	        idx[i] = -1;
	    
	    int minidx = Integer.MAX_VALUE;
	    
	    for (int i = 0; i < n; i++){
	        if(idx[a[i]] != -1)
	            minidx = Math.min(minidx, idx[a[i]]); 
	        else
	            idx[a[i]] = i;
	    }
	    
	    if(minidx == Integer.MAX_VALUE)
	        System.out.println("-1");
	    
	    else
	    	System.out.println(minidx + 1);	
	}
	
}
