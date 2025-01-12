import java.util.Scanner;

public class Main {
	
	public static int sum (int n) {
		if(n==1)
			return 0;
		if(n % 2 ==0) {
			return sum(n/2)+1;
		}
		else {
			return sum(n/3)+1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int ans = sum(n);
		System.out.println(ans);
	
		sc.close();
    }
}