import java.util.Scanner;

public class Main {
	
	public static int n;
	
	public static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp = new int[n+1];
		
		if(n>=3) {
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			
			for(int i=3; i<=n; i++) {
				dp[i] = dp[i-1]+dp[i-2];
			}
			System.out.println(dp[n]);
		}
		else
			System.out.println(1);
		
		
		sc.close();
	}
}