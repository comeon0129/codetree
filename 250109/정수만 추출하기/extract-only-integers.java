import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String a = sc.next();
    	String b = sc.next();
    	for(int i=0; i<a.length(); i++) {
    		if(!(a.charAt(i)>='0' && a.charAt(i)<='9')) {
    			a= a.substring(0,i);
    		}
    	}
    	for(int i=0; i<b.length(); i++) {
    		if(!(b.charAt(i)>='0' && b.charAt(i)<='9')) {
    			b= b.substring(0,i);
    		}
    	}
    	int sum = Integer.parseInt(a)+Integer.parseInt(b);
    	System.out.println(sum);
        sc.close();
    }
}