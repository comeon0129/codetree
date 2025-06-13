import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x, y;
	
	public Pair(int x , int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n; // 격자 크기
	public static int k; //초기에 상해있는 귤의 수
	public static int[][] grid; 
	public static boolean[][] visited;
	public static int[][] time; //해당 좌표의 귤이 상하는데 걸리는 시간
	public static Queue<Pair> q = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n; 
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] || grid[x][y] == 0)
			return false;
		return true;
	}
	
	public static void bfs() {
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x +dx[i];
				int ny = p.y+dy[i];
				
				if(canGo(nx,ny)) {
					push(nx,ny,time[p.x][p.y]+1);
				}
			}
		}
	}
	
	public static void push(int x, int y, int t) {
		visited[x][y] = true;
		time[x][y] = t;
		q.add(new Pair(x,y));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		time = new int[n][n];
				
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
				
				if(grid[i][j] == 2)
					push(i,j,0);
			}
		}
		
		bfs();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 0)
					System.out.print(-1+" ");
				else {
					if(visited[i][j])
						System.out.print(time[i][j]+" ");
					else
						System.out.print(-2+" ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}