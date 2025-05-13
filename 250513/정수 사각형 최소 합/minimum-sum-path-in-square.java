import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[][] dp = new int[MAX_N+1][MAX_N+1];
	public static int[][] grid = new int[MAX_N+1][MAX_N+1];
	
	public static void initialize() {
		dp[1][n] = grid[1][n];
		for(int i=2; i<=n; i++) {
			dp[i][n] = dp[i-1][n]+grid[i][n];
		}
		
		for(int i=n-1; i>=1; i--) {
			dp[1][i] = dp[1][i+1]+grid[1][i];
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
			for(int j=n-1; j>=1; j--) {
				dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j+1]+grid[i][j]);
			}
		}
		
		System.out.println(dp[n][1]);
		
		sc.close();
	}
}
