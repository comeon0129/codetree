import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s= sc.next();
    	int cnt1 = 0;
    	int cnt2 = 0;
    	for(int i=0; i<s.length()-1; i++) {
    		if(s.substring(i,i+2).equals("ee")) {
    			cnt1++;
    		}
    		if(s.substring(i,i+2).equals("eb")) {
    			cnt2++;
    		}
    	}
    	System.out.println(cnt1+" "+cnt2);
        sc.close();
    }
}