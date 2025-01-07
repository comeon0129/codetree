import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s = sc.nextLine();
    	char c = sc.next().charAt(0);
    	int cnt =0;
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i)==c){
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
    	
        sc.close();
    }
}