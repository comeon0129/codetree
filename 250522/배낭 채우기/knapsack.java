import java.util.Scanner;


public class Main {
	public static int n,m; // n: 보석의 개수, m: 무게의 합
	public static int[] w;
	public static int[] v;
	public static int[] dp;
	
	public static void initalize() {
		for(int i=0; i<=m; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		dp[0] = 0;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		w = new int[n];
		v = new int[n];
		dp = new int[m+1];
		
		for(int i=0; i<n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		initalize();
		
		for(int i=0; i<n; i++) {
			for(int j=m; j>=0; j--) {
				if(j < w[i] || dp[j-w[i]] == Integer.MIN_VALUE) 
					continue;
				dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
			}
		}
		
		int ans = 0;
		
		for(int i=0; i<=m; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
