import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s1 = sc.nextLine();
    	String s2 = sc.nextLine();
    	
    	System.out.print(s1.replace(" ", ""));
    	System.out.print(s2.replace(" ", ""));
    	
    	
        sc.close();
    }
}