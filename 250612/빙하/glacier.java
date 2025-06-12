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
	public static int n,m; //격자의 크기
	public static int[][] grid;
	
	public static boolean[][] visited;
	public static Queue<Pair> q = new LinkedList<>();
	
	public static int time = 0; //마지막으로 빙하가 녹는 시간
	public static int lastIceSize = -1; //마지막으로 녹은 빙하크기
	
	//해당 좌표가 격자 안에 존재하는지 확인하는 함수
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
	
	//bfs를 통해 이동할때 해당 좌표로 이동할 수 있는지 확인하는 함수
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(grid[x][y] != 0 || visited[x][y])
			return false;
		
		return true;
	}
	
	//격자 안에 아직 빙하가 있는지 확인하는 함수
	public static boolean isIceExists() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(grid[i][j] == 1)
					return true;
			}
		}
		return false;
	}
	
	//매번 반드시 초기화 해줘야 하는 사항들을 담은 함수
	public static void initalize() {
		visited = new boolean[n][m];
		visited[0][0] = true;
		q.add(new Pair(0,0));
	}
	
	//빙하에 둘러쌓여있지 않은 물들의 좌표에 대해 visited[][] = true로 만드는 함수
	public static void bfs() {
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int newX = p.x+dx[i];
				int newY = p.y+dy[i];
				
				if(canGo(newX, newY)) {
					visited[newX][newY] = true;
					q.add(new Pair(newX,newY));
				}

			}
		}
	}
	
	//주변에 빙하에 둘러쌓여있지 않은 물이 있는지 확인하는 함수
	public static boolean isAroundWater(int x, int y) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(inRange(nx,ny) && visited[nx][ny])
				return true;
		}
		return false;
	}
	
	//주변에 빙하에 둘러쌓여있지 않은 물이 있는 빙하들을 녹이는 함수
	public static void melt() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(grid[i][j] == 1 && isAroundWater(i,j)) {
					grid[i][j] = 0;
					lastIceSize++;
				}
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
		
		while(isIceExists()) {
			initalize();
			time++;
			lastIceSize = 0;
			
			bfs();
			melt();
		}
		
		System.out.println(time+" "+lastIceSize);
		
		sc.close();
	}
}
