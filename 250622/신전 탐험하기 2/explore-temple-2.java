import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] temple;
	public static int[][][] dp; // dp[i][j][k] : i번째 층까지 탐사했을 때,
//	마지막 방의 방향이 j이고 1층에서 들어간 방의 방향이 k일때의 획득할 수 있는 보물의 최대 개수
	
	public static void initalize() {
		dp = new int[n+1][3][3];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}
		
		for(int j=0; j<3; j++) {
			dp[1][j][j] = temple[1][j];
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
					if(i == n && j == k) //n층을 탐사할때 마지막에 들어간 방의 방향과 1층에서 들어간 방의 방향이 같으면 안됌
						continue;
					
					for(int l=0; l<3; l++) {
						if(l != j)
							dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][l][k]+temple[i][j]);
					}
				}
			}
		}
		
		int ans = -1;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				ans =Math.max(ans, dp[n][i][j]);
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}