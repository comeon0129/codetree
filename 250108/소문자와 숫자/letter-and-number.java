import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s = sc.next();
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
    			System.out.print((char)(s.charAt(i)-'A'+'a'));
    		}
    		else if(s.charAt(i)>='a' && s.charAt(i)<='z') {
    			System.out.print(s.charAt(i));
    		}
    		else if(s.charAt(i)>='0' && s.charAt(i)<='9') {
    			System.out.print(s.charAt(i));
    		}
    	}
    	
    	
 
        sc.close();
    }
}
