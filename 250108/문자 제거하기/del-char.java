import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	while(true) {
    		if(s.length() <= 1)
    			break;
    		int n = sc.nextInt();
    		if(n>=s.length()) {
    			s=s.substring(0,s.length()-1);
    			System.out.println(s);
    		}
    		else{
    			s=s.substring(0,n)+s.substring(n+1);
    			System.out.println(s);
    		}	
    	}
    	
    	
    	
    	
    	
        sc.close();
    }
}