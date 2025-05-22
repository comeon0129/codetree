import java.util.Scanner;


public class Main {
	public static int n;
	public static int[] arr;
	public static int[] dp;
	
	public static void initalize() {
		for(int i=0; i<n; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		dp[0] = arr[0];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		initalize();
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}