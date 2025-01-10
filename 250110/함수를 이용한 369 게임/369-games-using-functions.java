import java.util.Scanner;

public class Main {
	
	public static boolean isIn369(int n) {
		String s = Integer.toString(n);
		boolean test = false;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) =='3' || s.charAt(i)=='6' || s.charAt(i) == '9'){
				test = true;
				return test;
			}
		}
		return test;
	}
	
	
	
	public static boolean test(int n) {
		return n % 3 == 0 || isIn369(n); 
	}
	
	
	
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int cnt =0;
    	for(int i=a; i<=b; i++) {
    		if(test(i)) {
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
        sc.close();
    }
}