
import java.util.Scanner;


public class Main {
	public static int n; //격자 크기
	public static int m; //폭탄 터질 횟수
	public static int c; // 터트릴 열의 위치
	
	public static int[][] grid;
	
	//중력을 기반으로 아래로 다 내리는 함수
	public static void gravity() {
		int[][] temp = new int[n+1][n+1];
		
		for(int j=1; j<=n; j++) {
			int tempIdx = n;
			for(int i=n; i>=1; i--) {
				if(grid[i][j] != 0) {
					temp[tempIdx][j] = grid[i][j];
					tempIdx--;
				}
			}
		}
		
		grid = temp;
	}
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	//행과 열과 터지는 사이즈 기반으로 실제 폭탄을 터트리는 함수
	public static void bomb(int size, int x, int y) {
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		grid[x][y] = 0;
		
		int org_x = x;
		int org_y = y;
		for(int i=0; i<4; i++) {
			for(int j= 2; j<=size; j++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(inRange(nx,ny)) {
					grid[nx][ny] = 0;
				}
				x = nx;
				y = ny;
			}
			x = org_x;
			y = org_y;
		}
		return;
	}
	
	
	//폭탄이 터질 열의 위치 c를 기반으로 격자를 변화시키는 함수
	public static void changeGrid() {
		int bombSize = -1;
		int bombIdx = -1;
		//1. 터질 행 찾기
		for(int i=1; i<=n; i++) {
			if(grid[i][c] != 0) {
				bombSize = grid[i][c];
				bombIdx = i;
				break;
			}
		}
		
		//터질 폭탄이 없다면 return
		if(bombSize == -1)
			return;
		
		//터트리고
		bomb(bombSize,bombIdx, c);
		
		//중력 작용
		gravity();
		
		return;
	}
	
	public static void printGrid() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		while(m-->0) {
			c = sc.nextInt();
			changeGrid();
			
		}
		
		printGrid();
		
		sc.close();
	}
}

