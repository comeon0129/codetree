import java.util.Scanner;


public class Main {
	
	public static int n,m;
	public static int[][] board;
	public static int[][] dp;
	 
	public static void initalize() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		initalize();
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				for(int k=0; k<i; k++) {
					for(int l=0; l<j; l++){
						if(board[k][l] < board[i][j])
							dp[i][j] = Math.max(dp[i][j], dp[k][l]+1);
					}
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}
