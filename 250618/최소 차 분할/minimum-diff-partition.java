import java.util.Scanner;

public class Main {
	
	public static int n ;
	public static int[] arr;
	
	public static boolean[][] dp; // i번째 원소까지 고려할때 합이 j가 될 수 있는지 여부를 나타내는 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		int sum = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		
		dp = new boolean [n+1][sum];
		
		dp[0][0] = true;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<sum; j++) {
//				case1. i번째 원소를 합에 포함시키는 경우 
				if(j >= arr[i] && dp[i-1][j-arr[i]])
					dp[i][j] = true;
//				case2. i번째 원소 없이 합 j가 가능한 경우
				if(dp[i-1][j])
					dp[i][j] = true;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int j=1; j<sum; j++) {
			if(dp[n][j])
				ans = Math.min(ans, Math.abs(sum-2*j));
		}
		
		System.out.println(ans);
		sc.close();
	}
}