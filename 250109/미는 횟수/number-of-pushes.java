import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String a = sc.next();
    	String b = sc.next();
    	
    	int n = 0;
    	
    	for(int i=0; i<a.length(); i++) {
    		a= a.substring(a.length()-1)+a.substring(0,a.length()-1);
    		n++;
    		if(a.equals(b)) {
    			System.out.println(n);
    			break;
    		}
    	}
    	
    	if(n == a.length()) {
    		System.out.println(-1);
    	}

        sc.close();
    }
}
