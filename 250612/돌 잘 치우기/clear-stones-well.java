import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;
	
	public Pair(int x, int y) {
		this.x=  x;
		this.y = y;
	}
	
}

public class Main {
	
	public static int n,k,m; // n: 격자의 크기 k:시작점의 수 m: 꼭 치워야할 돌의 개수
	public static int[][] grid; //격자
	public static boolean[][] visited; //bfs방문
	public static int maxSize; //최대 칸수
	public static int curSize; // 현재 칸수
	public static Pair[] start; // 시작 위치 저장
	
	public static ArrayList<Pair> stones = new ArrayList<>();
	
	public static Queue<Pair> q = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 1<= x && x<=n && 1<=y && y<=n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(visited[x][y] == true || grid[x][y] == 1)
			return false;
		return true;
	}
	
	public static void push(int x, int y) {
		curSize++;
		visited[x][y] = true;
		q.add(new Pair(x,y));
	}
	
	public static void bfs () {
		int[] dx = {1,0,-1,0}; //아래, 오른쪽, 위, 왼쪽 순서
		int[] dy = {0,1,0,-1}; 
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				
				if(canGo(newX, newY)) {
					push(newX,newY);
				}
			}
		}
	}
	
	public static void calcMaxSize() {
		visited = new boolean[n+1][n+1];

		curSize = 0;
		
		for(int i=0; i<k; i++) {
			int x = start[i].x;
			int y = start[i].y;
			
			push(x,y);
			
		}
		bfs();
		
		maxSize = Math.max(maxSize, curSize);
	
	}
	
	//현재까지 고른 돌의 개수가 cnt 개일때, curNum번째 위치의 돌을 치울지 말지 결정하는 함수
	public static void chooseStones(int curNum, int cnt) {
		if(cnt == m) {
			calcMaxSize();
			return;
		}
		
		if(curNum == stones.size())
			return;
		
		//해당하는 돌을 치우지 않는 경우
		chooseStones(curNum+1,cnt);
		
		//해당하는 돌을 치우는 경우
		grid[stones.get(curNum).x][stones.get(curNum).y] = 0;
		chooseStones(curNum+1,cnt+1);
		grid[stones.get(curNum).x][stones.get(curNum).y] = 1;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = sc.nextInt();
		

		grid = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
				if(grid[i][j] == 1)
					stones.add(new Pair(i, j));
			}
		}
		
		start = new Pair[k];
		for(int i=0; i<k; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			start[i] = new Pair(r,c);
		}
		
		chooseStones(0,0);
		
		System.out.println(maxSize);
		sc.close();
	}
}
