import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1];
		
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j= 1; j<=i; j++) {
				dp[i]+=(dp[i-j]*dp[j-1]);
			}
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}
