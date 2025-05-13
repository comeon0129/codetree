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
	
	public static int n,k; // n: 격자 크기 k: 이동 횟수
	public static int[][] grid;
	public static int [][] visited;
	public static Queue<Pair> q = new LinkedList<>();
	
	public static int r;
	public static int c;
	public static int curMaxVal = 0;
	
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static boolean canGo(int x, int y, int originVal) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == 1 || grid[x][y] >= originVal)
			return false;
		
		return true;
	}
	
	public static void bfs() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int originVal = grid[r][c];
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				
				if(canGo(newX,newY,originVal)) {
					if(grid[newX][newY] > curMaxVal) {
						curMaxVal = grid[newX][newY];
					}
					push(newX,newY);
				}
			}
		}
	}
	
	public static void findPos() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(visited[i][j] != 1)
					continue;
				
				if(grid[i][j] == curMaxVal) {
					r = i;
					c = j;
					return;
				}
				
			}
		}
	}
	
	public static void push(int x, int y) {
		visited[x][y] = 1;
		q.add(new Pair(x,y));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		r = sc.nextInt(); //초기 x
		c = sc.nextInt(); //초기 y
		
		while(k-->0) {
			visited = new int[n+1][n+1];
			push(r,c);
			bfs();
			if(curMaxVal == 0) //이동할수 없는 경우
				break;
			
			findPos();
			
			curMaxVal = 0;
		}
		
		System.out.println(r+" "+c);
		
		
		sc.close();
	}
}