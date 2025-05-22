import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] grid;
	public static int[][] memo;
	public static int ans = Integer.MIN_VALUE;
	
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static boolean canGo(int x, int y, int curVal) {
		if(!inRange(x,y))
			return false;
		
		if(grid[x][y] <= curVal)
			return false;
		
		return true;
	}
	
	public static void findMaxDist(int x, int y, int curX) {
		ans = Math.max(ans, curX);
		
		int[] dx = {-1,1,0,0}; // 상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX,newY,grid[x][y])) {
				findMaxDist(newX, newY, curX+1);
			}
		}
		
		return;
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		memo = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				findMaxDist(i,j,1);
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}