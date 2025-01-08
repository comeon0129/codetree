import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String s = sc.next();
    	char[] arr = s.toCharArray();
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i] >= 'a' && arr[i] <= 'z') {
    			System.out.print((char)(arr[i]-'a'+'A'));
    		}
    		else if(arr[i] >='A' && arr[i] <= 'Z') {
    			System.out.print((char)arr[i]);
    		}
    	}
    	
    	
 
        sc.close();
    }
}
