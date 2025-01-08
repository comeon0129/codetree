import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n1 = sc.nextInt();
    	int n2 = sc.nextInt();
    	
    	int n3 = n1+n2;
    	String s = Integer.toString(n3);
    	int cnt =0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i)=='1') {
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
    	
    	
    	
        sc.close();
    }
}
