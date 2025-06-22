import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] temple;
	public static int[][] dp; // dp[i][j] : i번째 층까지 탐사했을 때, 마지막 방의 방향이
	// j일때의 획득할 수 있는 보물의 최대 개수
	
	public static void initalize() {
		dp = new int[n+1][3];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<3; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		for(int j=0; j<3; j++) {
			dp[1][j] = temple[1][j];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		temple = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++) {
				temple[i][j] = sc.nextInt();
			}
		}
		
		initalize();
	
		for(int i=2; i<=n; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(k != j)
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+temple[i][j]);
				}
			}
		}
		
		int ans = -1;
		
		for(int i=0; i<3; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		
		System.out.println(ans);
		sc.close();
	}
}