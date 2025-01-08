import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s= sc.next();
    	String c = sc.next();
    	int ans = s.indexOf(c);
    	
    	if(ans==-1) {
    		System.out.println("No");
    	}
    	else
    		System.out.println(ans);
        sc.close();
    }
}
