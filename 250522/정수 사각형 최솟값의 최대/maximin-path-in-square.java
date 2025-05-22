import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] matrix;
	public static int[][] dp;
	
	
	
	public static void initalize() {
		dp[1][1] = matrix[1][1];		
		
		for(int i=2; i<=n; i++) {
			dp[i][1] = Math.min(dp[i-1][1], matrix[i][1]);
			dp[1][i] = Math.min(dp[1][i-1], matrix[1][i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		matrix = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}	
		dp = new int[n+1][n+1];
		
		initalize();
		
		//dp[i][j]: i,j 위치까지 오면서 갖게되는 최솟값중에 최대
		// 나자신이 가장 작은값일수도 있으니까 math.min이 바깥쪽에 놓이고 나자신과 양옆에서 오는 애들중에 최대인 애랑 비교
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=n; j++) {
				dp[i][j] = Math.min(matrix[i][j],Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		System.out.println(dp[n][n]);
		sc.close();
	}
}