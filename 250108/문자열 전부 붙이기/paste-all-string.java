import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	String totStr="";
    	for(int i=0; i<n; i++) {
    		totStr += sc.next();
    	}
    	
    	System.out.println(totStr);
    	
    	
        sc.close();
    }
}