import java.util.Scanner;

public class Main {
	
	public static int calc(int n) {
		if(n==1) {
			return 0;
		}
		if(n % 2 == 0) {
			return calc(n/2)+1;
		}
		else {
			return calc(3*n+1)+1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = calc(n);
		System.out.println(ans);
	
		sc.close();
    }
}