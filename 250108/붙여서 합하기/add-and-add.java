import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s1 = sc.next();
    	String s2 = sc.next();
    	
    	String s3 = s1+s2;
    	String s4 = s2+s1;
    	
    	int n1 = Integer.parseInt(s3);
    	int n2 = Integer.parseInt(s4);
    	
    	System.out.println(n1+n2);
 
        sc.close();
    }
}