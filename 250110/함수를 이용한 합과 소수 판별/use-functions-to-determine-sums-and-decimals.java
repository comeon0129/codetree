import java.util.Scanner;

public class Main {
	
	public static boolean isEven(int n) {
		String s = Integer.toString(n);
		int sum =0;
		for(int i=0; i<s.length(); i++) {
			sum += s.charAt(i)-'0';
		}
		if(sum % 2 ==0) {
			return true;
		}
		else
			return false;
	}
	
	
	public static boolean isPrime(int n) {
		for(int i=2; i<n; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int cnt =0;
    	
    	for(int i=a; i<=b; i++) {
    		if(isPrime(i) && isEven(i)) {
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
    	
    	
        sc.close();
    }
}
