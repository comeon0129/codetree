import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] red;
	public static int[] blue;
	public static int[][] dp; //i번째 원소를 마지막으로 뽑았을때 여태 뽑은 빨간색 카드가 j개 일때의 뽑은 숫자의 합의 최댓값
	
	public static final int MIN = Integer.MIN_VALUE;
	
	public static void initalize() {
		for(int i=0; i<2*n; i++) {
			for(int j=0; j<=n; j++) {
				dp[i][j] =MIN;
			}
		}
		dp[0][0] = blue[0];
		dp[0][1] = red[0];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		red = new int[2*n];
		blue = new int[2*n];
		dp = new int[2*n][n+1];
		for(int i=0; i<2*n; i++) {
			red[i] = sc.nextInt();
			blue[i] = sc.nextInt();
		}
		initalize();
		
		for(int i=1; i<2*n; i++) {
			for(int j=0; j<=n; j++) {
//				case1. i번째에 빨간색 카드를 뽑는 경우
				if(j>=1)
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+red[i]);
//				case2. i번째에 파란색 카드를 뽑는 경우
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+blue[i]);
			}
		}
		
		System.out.println(dp[2*n-1][n]);
		
		sc.close();
	}
	
}
