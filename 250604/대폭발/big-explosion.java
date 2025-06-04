import java.util.Scanner;

public class Main {
	public static int n; //격자 크기
	public static int m; // 폭탄의 개수를 셀 시각
	public static int r,c; //폭탄의 초기 위치
	
	public static int[][] grid;
	public static boolean[][] used;
	
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
		
	//조건이 맞으면 해당자리 주변으로 폭탄을 생성하는 함수 
	public static void makeBomb(int x, int y, int t) {
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		for(int i=0; i<4; i++) {
			int nx = x+t*dx[i];
			int ny = y+t*dy[i];
			
			if(inRange(nx,ny) && grid[nx][ny]!=1) {
				grid[nx][ny] = 1;
				used[nx][ny] = true;
			}
		}
		return;
	}
	
	//시간이 경과함에 따라 격자의 상태를 변화시키는 함수
	public static void changeGrid(int t) {
		if(t == m+1)
			return;
		
		used = new boolean[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j] == 1 && !used[i][j]) {
					makeBomb(i,j,t); 
					used[i][j] = true;
				}
			}
		}
				
		changeGrid(t+1);
		
		return;
	}
	
	public static int calcCnt() {
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++){
				if(grid[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		grid = new int[n+1][n+1];
		
		grid[r][c]= 1;
		
		changeGrid(1);
		
		int bombCnt  = calcCnt();
		
		
		System.out.println(bombCnt);
		
		sc.close();
	}
}