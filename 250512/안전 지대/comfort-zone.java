import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[][] grid;
	
	public static boolean[][] visited;
	
	public static int k; //비의 양
	
	public static int safetyArea; //안전영역의 개수
	
	public static int maxSafe = 0; //최대 안전영역의 개수
	
	public static int maxK = 0;//최대 안전영역을 가질때의 k값 
	
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x<n && 0<=y && y<m;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == true || grid[x][y] <= k)
			return false;
		return true;
	}
	
	public static void dfs (int x, int y) {
		int[] dx = {1,0,-1,0}; //아래, 오른쪽, 위, 왼쪽 순서
		int[] dy = {0,1,0,-1}; 
		
		for(int i=0; i<4; i++) {
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
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		
		for(k=1; k<=100; k++) {
			
			visited = new boolean[n][m];
			safetyArea = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(canGo(i, j)) {
						safetyArea++;
						visited[i][j] = true;
						dfs(i,j);
					}
						
				}
			}
			if(safetyArea > maxSafe) {
				maxSafe = safetyArea;
				maxK = k;
			}
			
		}
		
		System.out.print(maxK+" "+maxSafe);
		
		sc.close();
	}
}