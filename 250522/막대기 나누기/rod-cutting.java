import java.util.Scanner;


public class Main {
	public static int n; // n: 막대기의 길이
	public static int[] profit;
	public static int[] length;
	public static int[] dp;
	
	public static void initalize() {
		for(int i=0; i<=n; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		dp[0] = 0;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		profit = new int[n];
		length = new int[n];
		dp = new int[n+1];
		
		for(int i=0; i<n; i++) {
			profit[i] = sc.nextInt();
			length[i] = i+1;
		}
		initalize();
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<n; j++) {
				if(i < length[j] || dp[i-length[j]] == Integer.MIN_VALUE)
					continue;
				dp[i] = Math.max(dp[i], dp[i-length[j]]+profit[j]);
			}
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}