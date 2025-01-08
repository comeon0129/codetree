import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int sum =0;
    	int cnt =0;
    	for(int i=0; i<n; i++) {
    		String s = sc.next();
    		sum+=s.length();
    		if(s.charAt(0) == 'a') {
    			cnt++;
    		}
    	}
    	System.out.println(sum+" "+cnt);
    	
    	
        sc.close();
    }
}