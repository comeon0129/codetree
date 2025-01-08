import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		String s = sc.next();
    		if(s.equals("END")) {
    			break;
    		}
    		for(int i=0; i<s.length(); i++) {
    			System.out.print(s.charAt(s.length()-i-1));
    		}
    		System.out.println();
    		
    		
    	}

        sc.close();
    }
}

