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
	public static int k; //고를 도시의 수
	public static int u;
	public static int d;
	
	public static int[][] grid; 
	public static boolean[][] choose; //선택된 도시가 무엇인지 담을 배열
	
	public static boolean[][] visited;
	
	public static int maxCnt = Integer.MIN_VALUE;
	
	public static Queue<Pair> q = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n; 
	}
	
	public static boolean canGo(int x, int y, int curVal) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] || Math.abs(curVal-grid[x][y]) > d || Math.abs(curVal-grid[x][y]) < u)
			return false;
		return true;
	}
	
	public static int bfs() {
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			cnt++;
			
			for(int i=0; i<4; i++) {
				int nx = p.x +dx[i];
				int ny = p.y+dy[i];
				
				if(canGo(nx,ny,grid[p.x][p.y])) {
					visited[nx][ny] = true;
					q.add(new Pair(nx,ny));
				}
			}
		}
		
		return cnt;
	}
	
	
	public static int calcCnt() {
		visited = new boolean[n][n]; 
	
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(choose[i][j]) {
					visited[i][j] = true;
					q.add(new Pair(i,j));
				}
			}
		}
		
		return bfs();
	}
	
	public static void chooseCity(int curX, int curY, int cnt) {
		if(cnt == k) {
			maxCnt = Math.max(maxCnt, calcCnt());
			return;
		}
		
		if(curY== n) {
			curX++;
			curY = 0;
		}
		
		if(curX == n)
			return;
		
		//해당 좌표를 고르지 않는 경우
		chooseCity(curX, curY+1, cnt);
		
		//해당 좌표를 고르는 경우
		choose[curX][curY] = true;
		chooseCity(curX,curY+1, cnt+1);
		choose[curX][curY] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		grid = new int[n][n];
		choose = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		chooseCity(0,0,0);
		
		System.out.println(maxCnt);
		
		sc.close();
	}
}