import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static String a;
	public static String b;
	
	public static int[][] dp;
	
	public static void findLCS() {
		int n = a.length();
		int m = b.length();
		ArrayList<Character> lcs = new ArrayList<>();
		int x = n-1;
		int y = m-1;
		
		while(dp[x][y] != 0) {
			
			if(dp[x-1][y] != dp[x][y] && dp[x][y-1] != dp[x][y]) { //왼쪽과 위쪽 모두와 값이 다른경우
				lcs.add(a.charAt(x));
				x--;
				y--;
			}
			else if(dp[x-1][y] == dp[x][y]) {
				x--;
			}
			else if(dp[x][y-1] == dp[x][y]) {
				y--;
			}
		}
		
		for(int i=lcs.size()-1; i>=0; i--)
			System.out.print(lcs.get(i));
		System.out.println();
	}
	
	public static void initalize() {
		int n = a.length();
		int m = b.length();
		
		if(a.charAt(1) == b.charAt(1))
			dp[1][1] = 1;
		else
			dp[1][1] = 0;
		
		for(int j=2; j<m; j++) {
			if(a.charAt(1) == b.charAt(j))
				dp[1][j] = 1;
			else
				dp[1][j] = dp[1][j-1];
		}
		
		for(int i=2; i<n; i++) {
			if(b.charAt(1) == a.charAt(i))
				dp[i][1] = 1;
			else
				dp[i][1] = dp[i-1][1];
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = " "+sc.next();
		b = " "+sc.next();
		
		int n = a.length();
		int m = b.length();
		
		dp = new int[n][m];
		
		initalize();
		
		for(int i=2; i<n; i++) {
			for(int j=2; j<m; j++) {
				if(a.charAt(i) == b.charAt(j))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		findLCS();
		
		sc.close();
	}
	
}
