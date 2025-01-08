import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int len = s.length();
    	if(len % 2 ==0) {
    		for(int i=len-1; i>=0; i-=2) {
        		System.out.print(s.charAt(i));
        	}
    	}
    	else {
    		for(int i=len-2; i>=0; i-=2) {
        		System.out.print(s.charAt(i));
        	}
    	}
    	
    	
        sc.close();
    }
}