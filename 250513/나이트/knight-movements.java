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
	
	public static int n;
	public static int[][] grid;
	public static int [][] visited;
	public static int [][] dist;
	public static Queue<Pair> q = new LinkedList<>();
	
	public static final int DIRNUM = 8;
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == 1)
			return false;
		
		return true;
	}
	
	public static void bfs() {
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {1,2,2,1,-1,-2,-2,-1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<DIRNUM; i++) {
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
	
		visited = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		
//		시작점
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		
//		끝점
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		push(r1,c1,0);
		bfs();
		
		if(visited[r2][c2] == 1)
			System.out.println(dist[r2][c2]);
		else
			System.out.println(-1);
		
		sc.close();
	}
}