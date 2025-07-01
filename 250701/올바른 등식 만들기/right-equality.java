
import java.util.Scanner;

public class Main {
	public static int n,m;
	public static int[] num;
	public static long[][] dp;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new long[n+1][41]; // dp[i][j]: i번째 숫자까지 고려했을때, 합이 j가 되게 하는 가짓수
        num = new int[n+1];
        for(int i=1; i<=n; i++)
        	num[i] = sc.nextInt();
        dp[1][20-num[1]] =1;
        dp[1][20+num[1]] = 1;
        
        for(int i=1; i<n; i++) {
        	for(int j=0; j<=40; j++) {
        		if(0<= j-num[i+1] )
        			dp[i+1][j-num[i+1]] += dp[i][j];
        		
        		if(j+num[i+1] <=40)
        			dp[i+1][j+num[i+1]] += dp[i][j];
        	}
        }
        
        System.out.println(dp[n][m+20]);
        
        sc.close();
    }
}