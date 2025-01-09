import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int q = sc.nextInt();
    	
    	for(int i=0; i<q; i++) {
    		int num = sc.nextInt();
    		
    		if(num == 1) {
    			int a = sc.nextInt();
    			int b = sc.nextInt();
    			char[] arr = s.toCharArray();
    			char tmp = arr[a-1];
    			arr[a-1] = arr[b-1];
    			arr[b-1] = tmp;
    			s= String.valueOf(arr);
    			System.out.println(s);
    		}
    		else if(num == 2) {
    			char a= sc.next().charAt(0);
    			char b= sc.next().charAt(0);
    			s= s.replace(a, b);
    			System.out.println(s);
    		}
    	}
    	
    		
        sc.close();
    }
}