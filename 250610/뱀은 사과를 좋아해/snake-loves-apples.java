import java.util.ArrayList;
import java.util.Scanner;

class Body{
	public int x, y;
	
	public Body(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	public static int n; // 격자의 크기
	public static int m; //사과의 개수
	public static int k; // 뱀의 방향 변환 횟수
	
	public static int[][] grid; //사과가 놓일 격자판 영역
	
	public static int time = 0; //총 뱀이 움직인 시간
	
	public static ArrayList<Body> snake = new ArrayList<>();
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static boolean isIntersect(int x, int y) {
		for(int i=0; i<snake.size(); i++) {
			if(snake.get(i).x == x && snake.get(i).y == y)
				return true;
		}
		return false;
	}
	
	public static void move(int dirNum, int moveCnt) {
		
		int[] dx = {-1,1,0,0}; // 위, 아래,오른쪽, 왼쪽 순서
		int[] dy = {0,0,1,-1};
		
		while(moveCnt-->0) {
			int x = snake.get(snake.size()-1).x; //머리부분의 x좌표
			int y = snake.get(snake.size()-1).y; //머리부분의 y좌표
			time++;
			int nx = x+dx[dirNum];
			int ny = y+dy[dirNum];
			
			if(!inRange(nx,ny) || isIntersect(nx,ny)) {
				System.out.println(time);
				System.exit(0);
			}
			
			if(grid[nx][ny] == 1) { //사과가 있는 경우
				snake.add(new Body(nx,ny));
				grid[nx][ny] = 0;
			}
			
			else if(grid[nx][ny] == 0) {
				snake.add(new Body(nx,ny));
				snake.remove(0);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n+1][n+1];
	
		while(m-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			grid[x][y] = 1; // 사과가 존재하면 1
		}
		
		snake.add(new Body(1,1));
		
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