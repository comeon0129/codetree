import java.util.Scanner;

public class Main {
	
	public static int calc(int n) {
		if(n % 2 !=0) {
			if(n==1) {
				return 1;
			}
			return n+calc(n-2);
		}
		else {
			if(n==2) {
				return 2;
			}
			return n+calc(n-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int ans = calc(n);
		System.out.println(ans);
	
		sc.close();
    }
}