import java.util.Scanner;

public class Main {
	
	public static int n,m; // n: row의 개수 m: column의 개수
	
	public static int[][] grid;
	
	public static boolean[][] visited;
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x<n && 0<=y && y<m;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == true || grid[x][y] == 0)
			return false;
		return true;
	}
	
	public static void dfs (int x, int y) {
		int[] dx = {1,0};
		int[] dy = {0,1};
		
		for(int i=0; i<2; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX,newY)) {
				visited[newX][newY] = true;
				dfs(newX,newY);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		visited[0][0] = true;
		dfs(0,0);
		
		if(visited[n-1][m-1])
			System.out.println(1);
		else
			System.out.println(0);
		
		
		sc.close();
	}
}
