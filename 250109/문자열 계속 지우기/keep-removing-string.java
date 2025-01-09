import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String a = sc.next();
    	String b = sc.next();
    	while(true) {
    		int idx = a.indexOf(b);
    		if(idx ==-1) {
    			System.out.println(a);
    			break;
    		}
    		a= a.substring(0,idx)+a.substring(idx+b.length());
    	}
    		
        sc.close();
    }
}
