import java.util.Scanner;

public class Main {
	public static int n; //숫자의 개수
	public static int k; //최대 허용하는 음수의 개수
	public static int[] map;
	public static int[][] dp;
	
	public static void initalize() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=k; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		if(map[0] >=0)
			dp[0][0] = map[0];
		else
			dp[0][1] = map[0];
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[n];
		for(int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		
		dp = new int[n][k+1];
		initalize();
		
		for(int i=1; i<n; i++) {
			
//			case1. map[i]가 양수인 경우
			if(map[i]>=0) {
				for(int j=0; j<=k; j++) { //음수의 개수는 0개에서 k개 까지 만들어질 수 있음.
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+map[i]);
					dp[i][j] = Math.max(dp[i][j], map[i]);
				}
				
			}
//			case2. map[i]가 음수인 경우
			else {
				for(int j=1; j<=k; j++) { //음수의 개수는 1개에서 k개까지 만들어질 수 있음.
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+map[i]);
					dp[i][j] = Math.max(dp[i][j], map[i]);
				}
			}
		}
		
		int ans= Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=k; j++){
				ans = Math.max(ans, dp[i][j]);
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	
}
