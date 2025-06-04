import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static int n; // 격자의 크기
	public static int m; //사과의 개수
	public static int k; // 뱀의 방향 변환 횟수
	
	public static int[][] grid; //사과가 놓일 격자판 영역
	
	/*초기 상태 */
	public static int time = 0;
	public static int[][] snake;
	public static Deque<int[]> body = new LinkedList<>();
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static void move(int dirNum, int moveCnt) {
		if(!inRange(headX,headY) || snake[headX][headY] == 1)
			return;
		
		int[] dx = {-1,1,0,0}; // 위, 아래,오른쪽, 왼쪽 순서
		int[] dy = {0,0,1,-1};
		
		while(moveCnt-- >0) {
			int nx = headX+dx[dirNum];
			int ny = headY+dy[dirNum];
			
			if(grid[nx][ny] == 1){//사과가 존재했다면
				snake[headX][headY] = 1;
				grid[nx][ny] = 0;
			}
			else {
				
			}
			
			time++;
			headX= nx;
			headY = ny;
			
			if(!inRange(headX,headY) || snake[headX][headY] == 1)
				return;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n+1][n+1];
		snake = new int[n+1][n+1];
		
		while(m-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			grid[x][y] = 1; // 사과가 존재하면 1
		}
		
		while(k-->0) {
			char dir = sc.next().charAt(0);
			int moveCnt = sc.nextInt();
			int dirNum = -1;
			
			if(dir == 'U')
				dirNum = 0;
			else if(dir=='D')
				dirNum = 1;
			else if(dir == 'R')
				dirNum = 2;
			else
				dirNum = 3;
			
			move(dirNum,moveCnt);
		}
		
		System.out.println(time);
		
		sc.close();
	}
}