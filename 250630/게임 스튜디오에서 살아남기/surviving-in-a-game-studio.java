import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][][] dp;
	public static final int mod = 1000000007;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1][4][4]; // i번째 날에 T를 총합 j회 받고 B를 최근 k회 연속 받은 경우의 가짓수
        
        dp[1][1][0] = 1; // 첫째 날 T를 받은 경우
        dp[1][0][1] = 1; // 첫째 날 B를 받은 경우
        dp[1][0][0] = 1; // 첫째 날 G를 받은 경우
        
        for(int i=1; i<n; i++) {
        	for(int j=0; j<3; j++) {
        		for(int k=0; k<3; k++) {
//        			다음날 t를 받는 경우
        			dp[i+1][j+1][0] = (dp[i+1][j+1][0] + dp[i][j][k]) % mod;
//        			다음날 b를 받는 경우
        			dp[i+1][j][k+1] = (dp[i+1][j][k+1] + dp[i][j][k]) % mod;
//        			다음날 g를 받는 경우
        			dp[i+1][j][0] = (dp[i+1][j][0] + dp[i][j][k]) % mod;
        		}
        	}
        }
        
        int ans = 0;
        
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		ans = (ans + dp[n][i][j]) % mod;
        	}
        }
        System.out.println(ans);
        
        sc.close();
    }
}