import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] grid;
//	public static int[][] minDp;
	public static int[][] maxDp;
	
	public static void initalize() {
//		minDp[0][0] = grid[0][0];
		maxDp[0][0] = grid[0][0];
		
		for(int i=1; i<n; i++) {
//			최상단 줄 채우기
//			minDp[0][i] = Math.min(minDp[0][i-1], grid[0][i]);
			maxDp[0][i] = Math.max(maxDp[0][i-1], grid[0][i]);
			
//			맨 왼쪽 한줄 채우기
//			minDp[i][0] = Math.min(minDp[i-1][0], grid[i][0]);
			maxDp[i][0] = Math.max(maxDp[i-1][0], grid[i][0]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
//		minDp = new int[n][n];
		maxDp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		initalize();
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
//				minDp[i][j] = Math.min(grid[i][j], Math.max(minDp[i-1][j], minDp[i][j-1]));
				maxDp[i][j] = Math.max(grid[i][j], Math.min(maxDp[i-1][j], maxDp[i][j-1]));
			}
		}
		
	
		
		int ans = maxDp[n-1][n-1];
		
		System.out.println(ans);
		sc.close();
	}
}