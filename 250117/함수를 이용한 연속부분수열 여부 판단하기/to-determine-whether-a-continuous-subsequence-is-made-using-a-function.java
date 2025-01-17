import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
    public static int n1, n2;
    
    public static boolean test(int[] a, int[] b) {
    	for(int i=0; i<a.length-b.length+1; i++) {
    		int cnt = 0;
    		if(a[i] == b[0]) {
    			for(int j=0; j<b.length; j++) {
    				if(a[i+j] == b[j]) {
    					cnt++;
    				}
    			}
    			if(cnt == b.length) {
    				return true;
    			}
    		}  		
    	}
    	return false;
    }
    
    
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for(int i=0; i<n1; i++) {
        	a[i] =  sc.nextInt();
        }
        for(int i=0; i<n2; i++) {
        	b[i] =  sc.nextInt();
        }
        if(test(a,b)) {
        	System.out.println("Yes");
        }
        else
        	System.out.println("No");
        
        sc.close();
    }
}