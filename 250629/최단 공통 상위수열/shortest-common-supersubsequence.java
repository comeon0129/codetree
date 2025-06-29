import java.util.Scanner;
public class Main {
	public static int[][] dp ;
	public static String a;
	public static String b;
	
	
	public static void initalize() {
		int n = a.length();
		int m = b.length();
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		
		if(a.charAt(0) == b.charAt(0)) {
			dp[0][0] = 1;
		}
		else
			dp[0][0] = 2;
		
//		가로로 맨 윗줄 채우기 
		for(int j=1; j<m; j++) {
			if(a.charAt(0) == b.charAt(j))
				dp[0][j] = j+1;
			else
				dp[0][j] = dp[0][j-1]+1;
		}
		
//     세로로 맨 왼쪽 줄 채우기
		for(int i=1; i<n; i++) {
			if(b.charAt(0) == a.charAt(i))
				dp[i][0] = i+1;
			else
				dp[i][0] = dp[i-1][0]+1;
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        
        int n = a.length();
        int m = b.length();
        
        dp = new int[n][m];
        initalize();
        
        for(int i=1; i<n; i++) {
        	for(int j=1; j<m; j++) {
        		if(a.charAt(i) == b.charAt(j))
        			dp[i][j] = dp[i-1][j-1]+1;
        		else {
        			dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
        		}
        	}
        }
        
        System.out.println(dp[n-1][m-1]);
        
        sc.close();
    }
}