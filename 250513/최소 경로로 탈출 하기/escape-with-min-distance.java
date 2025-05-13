import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	public static int n,m; 
	public static int[][] grid;
	public static int [][] visited;
	public static int [][] dist;
	public static Queue<Pair> q = new LinkedList<>();
	
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == 1 || grid[x][y] == 0)
			return false;
		
		return true;
	}
	
	public static void bfs() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				
				if(canGo(newX,newY)) {
					push(newX,newY,dist[x][y]+1);
				}
			}
		}
	}
	
	public static void push(int x, int y, int s) {
		dist[x][y] = s;
		visited[x][y] = 1;
		q.add(new Pair(x,y));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		visited = new int[n][m];
		dist = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		push(0,0,0);
		bfs();
		
		if(visited[n-1][m-1] == 1)
			System.out.println(dist[n-1][m-1]);
		else
			System.out.println(-1);
		
		sc.close();
	}
}