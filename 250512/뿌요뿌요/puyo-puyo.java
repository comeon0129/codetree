import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[][] grid;
	
	public static boolean[][] isBomb;
	
	public static int blockSize; //지금 터지고 있는 블럭 사이즈
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x<n && 0<=y && y<n;
	}
	
	public static boolean canGo(int x, int y, int bombVal) {
		if(!inRange(x, y))
			return false;
		if(isBomb[x][y] == true || grid[x][y] != bombVal)
			return false;
		return true;
	}
	
	public static void dfs (int x, int y, int bombVal) {
		int[] dx = {1,0,-1,0}; //아래, 오른쪽, 위, 왼쪽 순서
		int[] dy = {0,1,0,-1}; 
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX,newY, bombVal)) {
				isBomb[newX][newY] = true;
				blockSize++;
				dfs(newX,newY,bombVal);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		grid = new int[n][n];
		isBomb = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int combo = 0;  //터지게 되는 블럭의 개수
		int maxBlockSize = 0; // 한번에 가장 크게 터지는 블럭의 크기
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!isBomb[i][j]) {
					isBomb[i][j] = true;
					int bombVal = grid[i][j];
					blockSize = 1;
					dfs(i,j,bombVal);
					
					maxBlockSize = Math.max(maxBlockSize, blockSize);
					if(blockSize >=4)
						combo++;
					
				}
			}
		}
		
		System.out.print(combo+" "+maxBlockSize);
		
		sc.close();
	}
}