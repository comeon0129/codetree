import java.util.Scanner;


public class Main {
	
	public static int[][] matrix;
	public static int n;
	public static int[][] dp;
	public static int minVal = Integer.MAX_VALUE;
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<= y && y<n;
	}
	
	public static void move(int x, int y) {
		if(x==n-1 && y == n-1)
			return;
		
		int num = dp[x][y];
		int num1 = 0;
		int num2 = 0;
		
		if(inRange(x,y+1)) {
			num1 = dp[x][y+1];
		}
		if(inRange(x+1,y)) {
			num2 = dp[x+1][y];
		}
		
		if(num1 > num2) {
			minVal = Math.min(minVal, num-num1);
			move(x,y+1);
		}
		else {
			minVal = Math.min(minVal, num-num2);
			move(x+1,y);
		}
		
		
		
	}
	
	public static void initalize() {
		dp[n-1][n-1] = matrix[n-1][n-1];
		
		for(int i=n-2; i>=0; i--) {
			dp[n-1][i] = dp[n-1][i+1]+matrix[n-1][i];
			dp[i][n-1] = dp[i+1][n-1]+matrix[i][n-1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		matrix = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		initalize();
		
		for(int i=n-2; i>=0; i--) {
			for(int j=n-2; j>=0; j--) {
				dp[i][j] = Math.max(dp[i+1][j]+matrix[i][j], dp[i][j+1]+matrix[i][j]);
			}
		}
		
		move(0,0);
		
		
		System.out.println(minVal);
		
		
		sc.close();
	}
}


