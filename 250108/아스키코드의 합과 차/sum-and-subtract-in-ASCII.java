import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char c1 = sc.next().charAt(0);
    	char c2 = sc.next().charAt(0);
    	
    	int plus = (int)(c1+c2);
    	int minus =(int)((c1>c2)? c1-c2 : c2-c1);
    	
    	System.out.println(plus +" "+minus);
        sc.close();
    }
}
