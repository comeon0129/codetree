import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int n = sc.nextInt();
    	for(int i=0; i<n; i++) {
    		if(n>s.length()) {
    			for(int j=0; j<s.length(); j++) {
    				System.out.print(s.charAt(s.length()-j-1));
    			}
    			break;
    		}
    		System.out.print(s.charAt(s.length()-i-1));
    	}
    	
    	
        sc.close();
    }
}