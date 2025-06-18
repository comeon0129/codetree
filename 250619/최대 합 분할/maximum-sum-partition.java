import java.util.Scanner;

public class Main {
	public static int n;
	public static int[] arr;
	public static int[][] dp; //dp[i][j] : i번째 수까지 고려했을때 A그룹 합 - B그룹 합이 j일때의 최대 A그룹 합
	
	public static int sum = 0;
	
	public static void update(int i, int j, int prevI, int prevJ, int val) {
		if(prevJ < 0 || prevJ >2*sum || dp[prevI][prevJ] == Integer.MIN_VALUE)
			return;
		
		dp[i][j] = Math.max(dp[i][j], dp[prevI][prevJ]+val);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			arr[i]= sc.nextInt();
			sum+=arr[i];
		}
		int OFFSET = sum; // 음수 인덱스를 피하기 위한 offset
		dp = new int[n+1][2*sum+1]; // j: -sum ~ sum을 표현하기 위해 2*sum+1

		for (int i = 0; i <= n; i++) {
		    for (int j = 0; j <= 2*sum; j++) {
		        dp[i][j] = Integer.MIN_VALUE;
		    }
		}
		
		dp[0][OFFSET] = 0; // 차이가 0인 시작 상태

		for(int i=1; i<=n; i++) {
			for(int j=0; j<=2*sum; j++) {
//				case1. i번째 수를 A그룹에 넣는 경우
				update(i,j, i-1, j-arr[i], arr[i]);
				
//				case2. i번째 수를 B그룹에 넣는 경우
				update(i,j,i-1, j+arr[i], 0);
				
//				case3. i번째 수를 C그룹에 넣는 경우
				update(i,j,i-1,j,0);	
			}
		}
		
		System.out.println(dp[n][OFFSET]);
		sc.close();
	}
}
