import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int q =sc.nextInt();
    	for(int i=0; i<q; i++) {
    		int num = sc.nextInt();
    		if(num == 1) {
    			s=s.substring(1)+s.substring(0,1);
    			System.out.println(s);
    		}
    		else if(num == 2) {
    			s=s.substring(s.length()-1)+s.substring(0,s.length()-1);
    			System.out.println(s);
    		}
    		else if(num == 3) {
    			char[] arr= s.toCharArray();
    			for(int j=0; j<arr.length/2; j++) {
        			char tmp = arr[j];
        			arr[j] = arr[arr.length-1-j];
        			arr[arr.length-1-j] = tmp;
    			}
    			s=String.valueOf(arr);
    			System.out.println(s);
    		}
    	}
    		
        sc.close();
    }
}