import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][n+1]; //dp[i][j]: 1번 플레이어가 i번째 카드까지 버리고,
        											  //2번 플레이어가 j번째 카드까지 버린 경우에
        											  //남우가 얻을 수 있는 최대 점수 
        for(int i=0; i<=n; i++) {
        	for(int j=0; j<=n; j++) {
        		dp[i][j] = -1;
        	}
        }
        dp[0][0] = 0;
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(dp[i][j] == -1)
        			continue;
        		
//        		첫번째 플레이어의 카드가 더 작은경우
        		if(a[i+1] < b[j+1]) {
        			dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
        		}
        		
//        		2번째 플레이어의 카드가 더 작은 경우
        		if(a[i+1] > b[j+1]) {
        			dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+b[j+1]);
        		}
        		
//        		둘다 카드 버리기
        		dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
        	}
        }
        
        int ans = 0;
        
        for(int i=0; i<=n; i++) {
        	ans =Math.max(ans, dp[i][n]);
        	ans = Math.max(ans, dp[n][i]);
        }
        
        System.out.println(ans);
        
        sc.close();
    }
}
	