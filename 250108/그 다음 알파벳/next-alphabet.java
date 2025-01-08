import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char c = sc.next().charAt(0);
    	if(c=='z') {
    		System.out.println('a');
    	}
    	else {
    		int num = (int) c +1;
    		System.out.println((char)num);
    	}
    	
    	
 
        sc.close();
    }
}