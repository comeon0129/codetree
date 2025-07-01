import java.util.Scanner;

public class Main {
	
	public static int n,m;
	public static int[] a;
	public static int[] b;
	
	public static int[][] dp;
	
	public static void findLCS() {
	    StringBuilder sb = new StringBuilder();
	    int x = n, y = m;

	    while (x > 0 && y > 0) {
	        if (a[x] == b[y]) {
	            sb.append(a[x]).append(" ");
	            x--;
	            y--;
	        } else {
	            if (dp[x-1][y] > dp[x][y-1]) {
	                x--;
	            } else if (dp[x-1][y] < dp[x][y-1]) {
	                y--;
	            } else {
	                // dp[x-1][y] == dp[x][y-1]인 경우: 사전순 비교
	                int tx = x - 1;
	                int ty = y - 1;
	                while (tx > 0 && ty > 0 && a[tx] == b[ty]) {
	                    tx--;
	                    ty--;
	                }

	                if (tx == 0 || ty == 0) {
	                    // 한쪽이 끝났다면 무조건 둘 중 작은 값으로
	                    if (a[x - 1] <= b[y - 1]) x--;
	                    else y--;
	                } else {
	                    if (a[tx] <= b[ty]) x--;
	                    else y--;
	                }
	            }
	        }
	    }

	    // 역으로 저장했기 때문에 뒤집어서 출력
	    String[] tokens = sb.toString().trim().split(" ");
	    for (int i = tokens.length - 1; i >= 0; i--) {
	        System.out.print(tokens[i] + " ");
	    }
	}
	
	public static void initalize() {
		if(a[1] == b[1])
			dp[1][1] = 1;
		else
			dp[1][1] = 0;
		
		for(int j=2; j<=m; j++) {
			if(a[1] == b[j])
				dp[1][j] = 1;
			else
				dp[1][j] = dp[1][j-1];
		}
		
		for(int i=2; i<=n; i++) {
			if(b[1] == a[i])
				dp[i][1] = 1;
			else
				dp[i][1] = dp[i-1][1];
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n+1];
		b = new int[m+1];
		
		for(int i=1; i<=n; i++)
			a[i] = sc.nextInt();
		
		for(int i=1; i<=m; i++)
			b[i] = sc.nextInt();
		
		dp = new int[n+1][m+1];
		
		initalize();
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=m; j++) {
				if(a[i] == b[j])
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		findLCS();
		
		sc.close();
	}
	
}
	