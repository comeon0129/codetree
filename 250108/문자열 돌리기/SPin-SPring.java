import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int len = s.length();
    	for(int i=0; i<len; i++) {
    		s=s.substring(s.length()-1)+s.substring(0,s.length()-1);
    		System.out.println(s);
    	}
    	
    	
        sc.close();
    }
}