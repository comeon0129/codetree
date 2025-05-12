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
	
	public static int n,k;
	public static int[][] grid;
	public static int [][] visited;
	public static Queue<Pair> q = new LinkedList<>();
	
	public static int cnt = 0;
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == 1 || grid[x][y] == 1)
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
				
				if(canGo(newX,newY))
					push(newX,newY);
			}
		}
	}

	public static void push(int x, int y) {
		visited[x][y] = 1;
		q.add(new Pair(x,y));
		cnt++;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		visited = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		while(k-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(canGo(x-1, y-1)) {
				push(x-1,y-1);
				bfs();
			}
		}
		System.out.println(cnt);
		
		sc.close();
	}
}
