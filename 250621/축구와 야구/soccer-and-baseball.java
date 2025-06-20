import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] football;
	public static int[] baseball;
//	dp[i][j][k]: i번째 ㅎ학생까지 고려했을때 여태 축구팀에 넣은 학생수가 j명이고
//	야구팀에 넣은 학생수가 k명일때, 두 팀 능력 합의 최대값
	public static int[][][] dp; 
	
	public static final int MIN = Integer.MIN_VALUE;
	
	public static void initalize() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=11; j++) {
				for(int k=0; k<=9; k++) {
					dp[i][j][k]=MIN;
				}
			}
		}
		dp[0][0][0] =0;
		dp[0][1][0] =football[0];
		dp[0][0][1] =baseball[0];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		football = new int[n];
		baseball = new int[n];
		dp = new int[n][12][10];
		for(int i=0; i<n; i++) {
			football[i] = sc.nextInt();
			baseball[i] = sc.nextInt();
		}
		initalize();
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=11; j++) {
				for(int k=0; k<=9; k++) {
					if(j>=1)
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k]+football[i]);
					
					if(k>=1)
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]+baseball[i]);
					
					dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
					
				}
			}
		}
		
		System.out.println(dp[n-1][11][9]);
		sc.close();
	}
	
}