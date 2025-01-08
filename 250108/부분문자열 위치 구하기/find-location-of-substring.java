import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String input= sc.next();
    	String target = sc.next();
    	
    	int ans = input.indexOf(target);
    	
    	System.out.println(ans);
    	
    	
        sc.close();
    }
}
