import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] grid;
	public static int[][] dp;
	
	public static void initalize() {
		dp = new int[n][n];
		dp[0][0] = grid[0][0];
		
		for(int i=1; i<n; i++) {
//			맨 윗줄 가로 채우기
			dp[0][i] = Math.max(dp[0][i-1], grid[0][i]);
//			맨 왼쪽 세로 채우기
			dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
		}
	}
	
	public static int solve(int lowerBound) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] < lowerBound) { 
					grid[i][j] = Integer.MAX_VALUE; //grid를 다시 초기화 해줄 필요가없는게 어차피 더 큰 lowerBound값이 들어오면 이전 애들은 당연히 다시 이 값을 바뀔거라 그렇다.
				}
			}
		}
		
		initalize();
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				dp[i][j] = Math.max(grid[i][j], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		return dp[n-1][n-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int lowerBound =1; lowerBound <=100; lowerBound++) {
			int minMax = solve(lowerBound);
			
			if(minMax == Integer.MAX_VALUE)
				continue;
			
			ans = Math.min(ans, minMax-lowerBound);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
}