import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] coins;
	public static int[][] dp; //dp[i][j]: i번째 층을 밟았을때 현재까지 1계단 단위로 오른 횟수가 j일때 얻을 수 있는 최대 동전 개수
	
	public static void initalize() {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<4; j++)
				dp[i][j] = Integer.MIN_VALUE;
		}
		dp[0][0] = 0;
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		coins = new int[n+1];
		dp = new int[n+1][4];
		for(int i=1; i<=n; i++)
			coins[i] = sc.nextInt();
		
		
		initalize();
		for(int i=1; i<=n; i++) {
			for(int j=0; j<4; j++) {
				
				if(j>=1 && dp[i-1][j-1] != Integer.MIN_VALUE)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+coins[i]);
				
				if(i>=2 && dp[i-2][j] != Integer.MIN_VALUE)
					dp[i][j] = Math.max(dp[i][j], dp[i-2][j]+coins[i]);
			}
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<4; i++) {
			ans= Math.max(ans, dp[n][i]);
		}
		
		System.out.println(ans);
		sc.close();
	}
	
}
