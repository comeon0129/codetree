import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s1 = sc.next();
    	String s2 = sc.next();
    	System.out.println(s1.length()+s2.length());

        
        sc.close();
    }
}