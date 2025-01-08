import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	String totStr="";
    	for(int i=0; i<n; i++) {
    		totStr += sc.next();
    	}
    	
    	for(int i=0; i<totStr.length(); i++) {
    		System.out.print(totStr.charAt(i));
    		if((i-4) % 5 == 0) {
    			System.out.println();
    		}
    	}
    	
    	
        sc.close();
    }
}