import java.util.Scanner;


public class Main {
	
	public static int n,r,c;
	
	public static int[] dx = {-1,1,0,0}; // 우선 순위가 상하좌우순서
	public static int[] dy = {0,0,-1,1};
	
	public static int cur_x, cur_y;
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static boolean simulate(int[][]grid) {
		
		for(int i=0; i<4; i++) {
			int next_x = cur_x+dx[i];
			int next_y = cur_y+dy[i];
			if(inRange(next_x,next_y)&&
					grid[next_x][next_y] > grid[cur_x][cur_y]) {
				cur_x = next_x;
				cur_y = next_y;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int[][] grid = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		cur_x = r;
		cur_y = c;
		
		while(true) {
			
			System.out.print(grid[cur_x][cur_y]+" ");
			if(!simulate(grid))
				break;
			
		}
	
		sc.close();
	}
}
