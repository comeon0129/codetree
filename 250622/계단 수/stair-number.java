import java.util.Scanner;

public class Main {
	public static int n; //숫자의 길이
	public static int[][] dp; //dp[i][j]: i번째 자리에 숫자까지 다 넣었을때, 마지막에
//	넣은 숫자가 j일때의 이 수를 만들기까지의 모든 계단수의 총합
	public static final int d = 1000000007;
	
	public static void initalize() {
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		
		dp = new int[n+1][10];
		
		initalize();
	
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j == 0)
					dp[i][j] = dp[i-1][j+1] % d;
				else if(j == 9)
					dp[i][j] = dp[i-1][j-1] % d;
				else
					dp[i][j] = (dp[i-1][j-1] +dp[i-1][j+1]) % d;
			}
		}
		
		int ans = 0;
		
		for(int i=0; i<=9; i++)
			ans = (ans +dp[n][i]) % d;
		
		System.out.println(ans);
		
		sc.close();
	}
}
