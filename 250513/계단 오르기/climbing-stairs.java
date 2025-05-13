import java.util.Scanner;

public class Main {
	public static final int MAX_N = 1000;
	
	public static int n;
	
	public static int[] dp = new int[MAX_N+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=n; i++) {
			dp[i] = (dp[i-2]+dp[i-3]) % 10007;
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}
