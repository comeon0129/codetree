import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	String s2="";
    	char[] arr =s.toCharArray();
    	int cnt =1;
    	for(int i=0; i<arr.length-1; i++) {
    		if(arr[i] != arr[i+1]) {
    			s2+=arr[i]+""+cnt;
    			cnt= 0;
    		}
    		cnt++;
    	}
    	s2+=arr[arr.length-1]+""+cnt;
    	System.out.println(s2.length());
    	System.out.println(s2);

    	
    		
        sc.close();
    }
}