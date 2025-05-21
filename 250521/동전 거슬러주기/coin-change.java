import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int n,m; // n: 동전의 종류 m: 금액
	
	public static int[] coins;
	
	public static int[] dp;
	
	public static void initalize() {
		dp[0] = 0;
		for(int i=1; i<=m; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		coins = new int[n];
		dp = new int[m+1];
		
		for(int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.sort(coins);
		
		initalize();
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<n; j++) {
				if(i< coins[j] || dp[i-coins[j]] == Integer.MAX_VALUE)
					continue;
				dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		
		
		if(dp[m] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else
			System.out.println(dp[m]);
		
		sc.close();
	}
}