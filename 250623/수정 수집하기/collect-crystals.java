import java.util.Scanner;

public class Main {
	public static int n, t;
	public static int[] crystal;
	public static int[][][] dp;
	//dp[i][j][k]: i번째 수정까지 내려왔을때, 마지막에 있던 위치가 j일때, 지금까지 움직인
    //횟수가 k일때의 최대 수정 개수
	
	public static void initalize() {
		dp = new int[n][2][t+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=1; j++) {
				for(int k=0; k<=t; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;
				}
			}
		}
		
		if(crystal[0] == 0) {
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
		crystal = new int[n];
		String s = sc.next();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'L')
				crystal[i] = 0;
			else
				crystal[i] = 1;
		}
		
		initalize();
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=1; j++) { //현재 위치
				for(int k=0; k<=t; k++) {
					for(int l=0 ;l<=1; l++) { //이전 위치
						int gain = 0;
						if(crystal[i] == j)
							gain++;
						
						if(j == l) {
							dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][l][k] + gain);
						}
						else {
							if(k>0) {
								dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][l][k-1] + gain);
							}
						}
					}
				}
			}
		}
		int answer = 0;
		for (int j = 0; j <= 1; j++) {
			for (int k = 0; k <= t; k++) {
				answer = Math.max(answer, dp[n-1][j][k]);
			}
		}
		System.out.println(answer);
	
		sc.close();
	}
}