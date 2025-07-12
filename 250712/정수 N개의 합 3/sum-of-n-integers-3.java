import java.util.Scanner;


public class Main {
	public static int n,k;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        int[][] prefixSum = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		grid[i][j] = sc.nextInt();
        	}		
        }
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		prefixSum[i][j] = prefixSum[i-1][j]+prefixSum[i][j-1] - prefixSum[i-1][j-1]+grid[i][j];
        	}		
        }
        

        int ans = Integer.MIN_VALUE;
        
        for(int i=1; i<=n-k+1; i++) {
        	for(int j=1; j<=n-k+1; j++) {
        		ans = Math.max(ans, prefixSum[i+k-1][j+k-1] - prefixSum[i-1][j+k-1] - prefixSum[i+k-1][j-1]+prefixSum[i-1][j-1]);
        	}
        }
        System.out.println(ans);
        sc.close();
    }
}
