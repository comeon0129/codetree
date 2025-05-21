import java.util.Scanner;

public class Main {
	public static int n,m; // n: 원소의 개수 , m: 수열 내 원소의 합
	public static int[] arr;
	public static int[] dp;
	
	public static void initalize() {
		for(int i=0; i<=m; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		dp = new int[m+1];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		initalize();
		
		for(int i=0; i<n; i++) {
			for(int j=m; j>=0; j--) {
				if(j< arr[i] || dp[j-arr[i]] == Integer.MAX_VALUE)
					continue;
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		
		if(dp[m] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
		sc.close();
	}
}