import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] grid;
	public static int maxTime = Integer.MIN_VALUE;
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static int gameStart(int x, int y, int dir) {
		
		
		int[] dx = {1,0,-1,0}; //아래 왼쪽 위 오른쪽
		int[] dy = {0,-1,0,1};
		
		int time = 1;
		
		while(inRange(x,y)) {
			
			if(grid[x][y] == 1) {
				if(dir == 0)
					dir=1;
				else if(dir== 1)
					dir=0;
				else if(dir==2)
					dir=3;
				else if(dir==3)
					dir=2;
			}
			else if(grid[x][y] == 2) {
				if(dir == 0 || dir == 3)
					dir=Math.abs(dir-3);
				else if(dir==1)
					dir = 2;
				else if(dir==2)
					dir = 1;
			}
			
			x= x+dx[dir];
			y= y+dy[dir];
			
			time++;
		}
		
		return time;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int startX = -1;
		int startY = -1;
		int dir = -1; // 0이면 아래 1이면 왼쪽 2면 위 3이면 오른쪽 방향으로 진행
		
		for(int k=1; k<=4*n; k++) {
			if(1<=k && k <= n) {
				startX = 1;
				startY = k;
				dir = 0;
			}
			else if(n+1<=k && k<=2*n) {
				startX = k-n;
				startY = n;
				dir = 1;
			}
			else if(2*n+1<=k && k <=3*n) {
				startX = n;
				startY = 3*n+1 -k;
				dir = 2;
			}
			else {
				startX = 4*n+1-k;
				startY = 1;
				dir = 3;
			}
			
			int time = gameStart(startX, startY, dir);
			maxTime =Math.max(maxTime, time);
			
		}
		
		System.out.println(maxTime);
		
		sc.close();
	}
}
