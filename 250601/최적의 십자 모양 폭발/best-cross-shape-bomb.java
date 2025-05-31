import java.util.Scanner;


public class Main {
	public static int n; //격자 크기
	
	public static int maxCnt =0;

	public static int[][] grid;
	
	public static void findMaxCnt() {
		int cnt = 0;
		//우선 가로 방향으로 체킹
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				if(grid[i][j] != 0 && grid[i][j] == grid[i][j+1])
					cnt++;
			}
		}
		//다음으로 세로 방향으로 체킹
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] != 0 && grid[i][j] == grid[i+1][j])
					cnt++;
			}
		}
		
		maxCnt = Math.max(maxCnt, cnt);
	}
	
	
	//중력을 기반으로 아래로 다 내리는 함수
	public static void gravity() {
		int[][] temp = new int[n][n];
		
		for(int j=0; j<n; j++) {
			int tempIdx = n-1;
			for(int i=n-1; i>=0; i--) {
				if(grid[i][j] != 0) {
					temp[tempIdx][j] = grid[i][j];
					tempIdx--;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		return;
	}
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
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
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int[][] org_grid = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				org_grid[i][j] = grid[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bomb(grid[i][j],i,j);
				gravity();
				findMaxCnt();
				
				for(int k=0; k<n; k++) {
					for(int l=0; l<n; l++) {
						grid[k][l] = org_grid[k][l];
					}
				}
			}
		}
		System.out.println(maxCnt);
		
		sc.close();
	}
}
