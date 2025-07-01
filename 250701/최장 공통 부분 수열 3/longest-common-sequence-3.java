import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static int n,m;
	public static int[] a;
	public static int[] b;
	
	public static int[][] dp;
	
	public static void findLCS() {
	    ArrayList<Integer> lcs = new ArrayList<>();
	    int x = n;
	    int y = m;

	    while (x > 0 && y > 0) {
	        if (a[x] == b[y]) {
	            lcs.add(a[x]);
	            x--;
	            y--;
	        }
	        else {
	        	if(dp[x-1][y] > dp[x][y-1])
	        		x--;
	        	else
	        		y--;
	        }
	    }

	    for (int i = lcs.size() - 1; i >= 0; i--) {
	        System.out.print(lcs.get(i) + " ");
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


	