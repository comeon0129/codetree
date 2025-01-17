import java.util.Scanner;

public class Main {
	public static final int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	
    public static int m, d;
    
    public static boolean isExist(int m, int d) {
    	int day = days[m-1];
    	for(int i=1; i<=day; i++) {
    		if(d == i) {
    			return true;
    		}
    	}
    	return false;
    }
    
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        d = sc.nextInt();
        
        if(isExist(m,d)) {
        	System.out.println("Yes");
        }
        else {
        	System.out.println("No");
        }
        
        sc.close();
    }
}