import java.util.Scanner;


public class Main {
	
	public static int n;
	public static int[] arr;
	public static int[] dp;
	 
	public static void initalize() {
		for(int i=0; i<n; i++) {
			dp[i] = 1;
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
				if(arr[j] > arr[i]) {
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