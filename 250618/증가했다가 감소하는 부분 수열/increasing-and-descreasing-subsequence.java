
import java.util.Scanner;

public class Main {
	
	public static int n ;
	public static int[] arr;
	public static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		dp = new int[n][2];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
//		initalize
		for(int i=0; i<n; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]+1);
				}
			}
		}
		
		//감소수열은 역순으로 
		for(int i=n-1; i>=0; i--) {
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
				}
			}
		}
		int ans = -1;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, dp[i][0]+dp[i][1]-1);
		}
		System.out.println(ans);
		sc.close();
	}
}