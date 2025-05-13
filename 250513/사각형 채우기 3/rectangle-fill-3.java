import java.util.Scanner;

public class Main {
	public static final int MAX_N = 1000;
	
	public static int n;
	
	public static int[] dp = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		for(int i=3; i<=n; i++) {
			dp[i] = (2*dp[i-1]+3*dp[i-2]+2) % 1000000007;
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}