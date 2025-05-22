import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] matrix;
	public static int[][] memo;
	
	public static int findMaxMinVal(int x, int y) {
		if(x>n || y>n)
			return Integer.MAX_VALUE;
		
		memo[x][y] = Math.max(memo[x][y],Math.min(matrix[x][y], findMaxMinVal(x+1,y)));
		memo[x][y] = Math.max(memo[x][y],Math.min(matrix[x][y], findMaxMinVal(x,y+1)));
		
		
		return memo[x][y];
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		matrix = new int[n+1][n+1];
		memo = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				memo[i][j] = -1;
			}
		}
		
		int ans = findMaxMinVal(1,1);
		
		System.out.println(ans);
		sc.close();
	}
}