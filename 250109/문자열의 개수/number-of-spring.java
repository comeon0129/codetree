import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String[] arr = new String[200];
    	int cnt=0;
    	
    	while(true) {
    		String s = sc.next();
    		if(s.equals("0")) {
    			System.out.println(cnt);
    			for(int i=0; i<cnt; i+=2) {
    				System.out.println(arr[i]);
    			}
    			break;
    		}
    		arr[cnt] = s;
    		cnt++;
    	}

        sc.close();
    }
}
