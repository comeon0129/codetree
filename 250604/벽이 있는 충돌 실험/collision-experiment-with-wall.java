import java.util.Scanner;

public class Main {
	public static int t;//총 테스트 횟수
	public static int n;//격자 크기
	public static int m;//구슬 개수
	
	public static int[][] grid;
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static void move() {
		int[] dx = {-1,1,0,0}; //상하 우좌 순서
		int[] dy = {0,0,1,-1};
		
		int[][] nextGrid = new int[n+1][n+1];
		int[][] nextCnt = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				nextGrid[i][j] = -1;
			}
		}
		
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=n; y++) {
				if(grid[x][y] != -1) {
					int dirNum = grid[x][y];
					
					int nx = x+dx[dirNum];
					int ny = y+dy[dirNum];
					
					if(!inRange(nx,ny)) {
						if(dirNum == 0) 
							nextGrid[x][y] = 1;
						else if(dirNum == 1)
							nextGrid[x][y] = 0;
						else if(dirNum == 2)
							nextGrid[x][y] = 3;
						else 
							nextGrid[x][y] =2;
						nextCnt[x][y]++;
					}
					else {
						nextGrid[nx][ny] = dirNum;						
						nextCnt[nx][ny]++;
					}
				}
			}
		}
		
		//충돌한 경우 없애버리기
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(nextCnt[i][j] >=2)
					nextGrid[i][j] = -1;
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = nextGrid[i][j];
			}
		}
		
		return;
	}
	
	public static int calcCnt() {
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j] != -1)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			grid = new int[n+1][n+1];
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					grid[i][j] = -1;
				}
			}
			
			while(m-->0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				char dir = sc.next().charAt(0);
				
				int dirNum = -1;
				
				if(dir== 'U')
					dirNum = 0;
				else if(dir == 'D')
					dirNum = 1;
				else if(dir == 'R')
					dirNum = 2;
				else
					dirNum = 3;
				
				grid[x][y] = dirNum;
			}
			
			for(int i=0; i < 2*n; i++) {
				move();
			}
			
			System.out.println(calcCnt());

		}
		
		sc.close();
	}
}