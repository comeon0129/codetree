import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x, y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n; //격자 크기
	public static int k; // 사람 수
	public static int m; // 비를 피하는 공간 수
	public static int[][] grid;
	public static int[][] ans;
	
	public static boolean[][] visited;
	public static int[][] dist;
	
	public static Queue<Pair> q = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x<n && 0<= y && y<n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x,y))
			return false;
		if(visited[x][y] || grid[x][y] == 1)
			return false;
		return true;
	}
	
	public static void bfs() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(canGo(nx,ny)) {
					push(nx,ny,dist[p.x][p.y]+1);
				}
			}
		}
	}
	
	public static void push(int x, int y, int s) {
		visited[x][y] = true;
		dist[x][y] = s;
		q.add(new Pair(x,y));
	}
	
	//사람이 서 있던 좌표를 받아 해당 좌표로 부터 비 피할 수 있는 공간까지의 최소 거리를 구하는 함수
	public static int calcMinDist(int x, int y) {
		visited = new boolean[n][n];
		dist  = new int[n][n];
		
		//dist배열 초기화
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = -1;
			}
		}
		
		//사람 위치 큐에 넣기
		push(x,y,0);
		
		int minDist = Integer.MAX_VALUE;
		bfs();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 3) {
					minDist =Math.min(minDist, dist[i][j]); 
				}
			}
		}
		
		return minDist;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int [n][n];
		ans = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 2) //사람이 있는 경우
					ans[i][j] = calcMinDist(i,j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}


