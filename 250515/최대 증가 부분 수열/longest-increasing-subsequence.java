import java.util.Scanner;


public class Main {
	
	public static int n;
	public static int[] arr;
	public static int[] dp;
	 
	public static void initalize() {
		dp[0] = 1;
		for(int i=1; i<n; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
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
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		
		sc.close();
	}
}