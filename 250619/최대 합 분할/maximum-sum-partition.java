import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] arr;
	public static int[][] dp; //dp[i][j] : i번째 수까지 고려했을때 A그룹 합 - B그룹 합이 j일때의 최대 A그룹 합
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		int sum = 0;
		
		
		for(int i=1; i<=n; i++) {
			arr[i]= sc.nextInt();
			sum+=arr[i];
		}
		int OFFSET = sum; // 음수 인덱스를 피하기 위한 offset
		dp = new int[n+1][2*sum+1]; // j: -sum ~ sum을 표현하기 위해 2*sum+1

		for (int i = 0; i <= n; i++) {
		    for (int j = 0; j <= 2*sum; j++) {
		        dp[i][j] = -1; // 불가능한 상태로 초기화
		    }
		}
		dp[0][OFFSET] = 0; // 차이가 0인 시작 상태

		for (int i = 1; i <= n; i++) {
		    for (int j = 0; j <= 2*sum; j++) {
		        if (dp[i-1][j] == -1) continue; // 이전 상태가 불가능하면 skip

		        // case 1: i번째 수를 아무 그룹에도 안 넣음 (C그룹)
		        dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);

		        // case 2: B 그룹에 넣는 경우 => 차이 감소
		        if (j - arr[i] >= 0)
		            dp[i][j - arr[i]] = Math.max(dp[i][j - arr[i]], dp[i-1][j]);

		        // case 3: A 그룹에 넣는 경우 => 차이 증가 + A합 증가
		        if (j + arr[i] <= 2*sum)
		            dp[i][j + arr[i]] = Math.max(dp[i][j + arr[i]], dp[i-1][j] + arr[i]);
		    }
		}

		System.out.println(dp[n][OFFSET]); // 차이가 0인 경우의 최대 A 그룹 합
		
		
		
		sc.close();
	}
}