import java.util.ArrayList;
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
	public static int k; //없앨 벽의 개수
	public static int minTime = Integer.MAX_VALUE; //걸리는 최소 시간
	public static int startX, startY; //시작하는 지점의 좌표
	public static int endX, endY; //끝나는 지점의 좌표
	public static int[][] grid; 
	public static boolean[][] visited;
	public static int[][] dist;
	public static ArrayList<Pair> walls = new ArrayList<>(); 
	public static Queue<Pair> q = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n; 
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] || grid[x][y] == 1)
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
					push(nx,ny,dist[p.x][p.y]+1);
				}
			}
		}
	}
	
	public static void push(int x, int y, int step) {
		visited[x][y] = true;
		dist[x][y] = step;
		q.add(new Pair(x,y));
	}
	
	public static int calcTime() {
		visited = new boolean[n][n];
		dist = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		push(startX-1,startY-1,0);
		bfs();
		
		return dist[endX-1][endY-1];
	}
	
	//지금까지 없애기로 결정한 벽이 cnt개일때, curNum번째 위치의 벽을 없앨지 말지 결정하는 함수
	public static void chooseRemoveWalls(int curNum, int cnt) {
		if(cnt == k) {
			minTime = Math.min(minTime, calcTime());
			return;
		}
		
		if(curNum == walls.size())
			return;
		
		//벽을 없애지 않는 경우
		chooseRemoveWalls(curNum+1, cnt);
		
		//벽을 없애는 경우
		grid[walls.get(curNum).x][walls.get(curNum).y] = 0;
		chooseRemoveWalls(curNum+1, cnt+1);
		grid[walls.get(curNum).x][walls.get(curNum).y] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
				if(grid[i][j] == 1)
					walls.add(new Pair(i,j));
			}
		}
		startX = sc.nextInt();
		startY = sc.nextInt();
		endX = sc.nextInt();
		endY = sc.nextInt();
		
		chooseRemoveWalls(0,0);
		
		if(minTime == Integer.MAX_VALUE)
			minTime = -1;
		
		System.out.println(minTime);
		sc.close();
	}
}