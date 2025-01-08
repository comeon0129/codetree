import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s1 = sc.next();
    	String s2 = sc.next();
    	
    	String s3 = "" , s4 = "";
    	for(int i=0; i<s1.length(); i++) {
    		if(s1.charAt(i)>='0' && s1.charAt(i)<='9') {
    			s3+=s1.charAt(i);
    		}
    	}
    	for(int i=0; i<s2.length(); i++) {
    		if(s2.charAt(i)>='0' && s2.charAt(i)<='9') {
    			s4+=s2.charAt(i);
    		}
    	}
    	System.out.println(Integer.parseInt(s3)+Integer.parseInt(s4));
        sc.close();
    }
}
