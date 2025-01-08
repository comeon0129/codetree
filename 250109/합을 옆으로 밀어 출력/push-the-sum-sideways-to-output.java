import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int sum =0;
    	for(int i=0; i<n; i++) {
    		sum+= sc.nextInt();
    	}
    	String s =Integer.toString(sum);
    	s= s.substring(1)+s.substring(0,1);
    	System.out.println(s);
        sc.close();
    }
}
