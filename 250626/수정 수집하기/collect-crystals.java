import java.util.Scanner;

public class Main {
	public static int n,t;
	public static int[] pos; //수정이 떨어질 위치 0이면 왼쪽 1이면 오른쪽
	public static int[][][]dp;
	
	public static void initalize() {
		dp = new int[n][t+1][2];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=t; j++) {
				for(int k=0; k<=1; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}
//		초기 조건
		if(pos[0] == 0) {
			dp[0][0][0] = 1;
			dp[0][1][1] = 0;
		}
		else {
			dp[0][0][0] = 0;
			dp[0][1][1] = 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		String s = sc.next();
		pos = new int[n];
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) =='L')
				pos[i] = 0;
			else
				pos[i] = 1;
		}
		
		initalize();
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=t; j++) {
//				현재 위치가 왼쪽(0)인 경우부터 처리
				if(pos[i] == 0) {
					if(j>=1) {
						if(dp[i-1][j-1][1] != Integer.MIN_VALUE)
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j-1][1]+1);
						
						if(dp[i-1][j-1][0] != Integer.MIN_VALUE)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j-1][0]);
					}
					
					if(dp[i-1][j][0] != Integer.MIN_VALUE)
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j][0]+1);
					
					if(dp[i-1][j][1] != Integer.MIN_VALUE)
						dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1]);
				}
				else {
					if(j>=1) {
						if(dp[i-1][j-1][0] != Integer.MIN_VALUE)
							dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j-1][0]+1);
						
						if(dp[i-1][j-1][1] != Integer.MIN_VALUE)
							dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j-1][1]);
					}
					
					if(dp[i-1][j][1] != Integer.MIN_VALUE)
						dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j][1]+1);
					
					if(dp[i-1][j][0] != Integer.MIN_VALUE)
						dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j][0]);
				}
			}
		}
		
		int ans = -1;
		
		for(int i=0; i<=t; i++) {
			ans = Math.max(ans, dp[n-1][i][0]);
			ans = Math.max(ans, dp[n-1][i][1]);
		}
		
		System.out.println(ans);
		sc.close();
	}
	
}
