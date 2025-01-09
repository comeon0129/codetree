import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String a = sc.next();
    	String b = sc.next();
    	for(int i=0; i<b.length(); i++) {
    		if(b.charAt(i) == 'L') {
    			a=a.substring(1)+a.substring(0,1);
    		}
    		else if(b.charAt(i) == 'R') {
    			a=a.substring(a.length()-1)+a.substring(0,a.length()-1);
    		}
    	}
    	System.out.println(a);
    
    		
        sc.close();
    }
}