import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[][] dp = new int[MAX_N+1][MAX_N+1];
	public static int[][] grid = new int[MAX_N+1][MAX_N+1];
	
	public static void initialize() {
		dp[1][1] = grid[1][1];
		for(int i=2; i<=n; i++) {
			dp[i][1] = dp[i-1][1]+grid[i][1];
			dp[1][i] = dp[1][i-1]+grid[1][i];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		initialize();
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=n; j++) {
				dp[i][j] = Math.max(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
			}
		}
		
		System.out.println(dp[n][n]);
		
		sc.close();
	}
}