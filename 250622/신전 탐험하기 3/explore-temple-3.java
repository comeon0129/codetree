import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	public static int[][] temple;
	public static int[][] dp; // dp[i][j] : i번째 층까지 탐사했을 때,
//	마지막 방의 번호가 j일때 획득할 수 있는 보물의 최대 개수
	
	public static void initalize() {
		dp = new int[n+1][m+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		for(int j=1; j<=m; j++) {
			dp[1][j] = temple[1][j];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		m = sc.nextInt();
		temple = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				temple[i][j] = sc.nextInt();
			}
		}
		
		initalize();
	
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				for(int k=1; k<=m; k++) {
					if(j != k)
						dp[i][j] =Math.max(dp[i][j], dp[i-1][k]+temple[i][j]);
				}
			}
		}
		
		int ans = -1;
		
		for(int j=1; j<=m; j++)
			ans = Math.max(ans, dp[n][j]);
		
		System.out.println(ans);
		sc.close();
	}
}