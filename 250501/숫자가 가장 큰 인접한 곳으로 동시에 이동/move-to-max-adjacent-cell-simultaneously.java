import java.util.Scanner;


public class Main {
	
	public static int n,m,t; // n: 격자의 크기 m: 구슬의 개수 t: 시간
	
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static void simulate(int curX, int curY, int[][]board, int[][] nextCount) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int maxNum = 0;
		int maxX=0, maxY=0;
		
		for(int i=0; i<4; i++) {
			int nextX = curX +dx[i];
			int nextY = curY +dy[i];
			
			if(inRange(nextX, nextY)&&
					board[nextX][nextY] > maxNum) {
				maxNum = board[nextX][nextY];
				maxX = nextX;
				maxY = nextY;
			}
		}
		
		nextCount[maxX][maxY]++;
		
	}
	
	public static void isIntersect(int[][] count) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(count[i][j]>=2)
					count[i][j] = 0;
			}
		}
	}
	
	public static int countMarbles (int[][] count) {
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(count[i][j] == 1)
					ans++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
	   
		int[][] board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int[][] count = new int[n][n];
		
		for(int i=0; i<m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			r--;
			c--;
			count[r][c]++;
		}
		
		
		while(t-->0) {
			int[][] nextCount = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(count[i][j] == 1) {
						simulate(i,j,board,nextCount);
					}
				}
			}
			count = nextCount;
			isIntersect(count);
		}
		
		System.out.println(countMarbles(count));
		
		
		sc.close();
	}
}
