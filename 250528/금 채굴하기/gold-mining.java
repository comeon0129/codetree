import java.util.Scanner;

public class Main {
	public static int n; //격자 크기 
	public static int m; //금 한개의 가격
	public static int[][] grid;
	
	public static int maxCnt = 0; // 최대 채굴가능한 금의 개수
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x < n && 0<= y && y<n;
	}
	
	public static int calcGold(int x, int y, int k) {
		if(k == 0) {
			if(grid[x][y] == 1)
				return 1;
			else
				return 0;
		}
		
		int gold = 0;
		
		//방사형으로 퍼지는 범위 부터 계산해주고
		for(int i = x-k+1; i<x+k; i++) {
			for(int j= y-k+1; j<y+k; j++) {
				if(inRange(i, j) && grid[i][j] == 1)
					gold++;
			}
		}
		// 끝에 꼬다리 네 부분 계산해주기
		if(inRange(x-k, y) && grid[x-k][y] == 1) {
			gold++;
		}
		if(inRange(x+k, y) && grid[x+k][y] == 1) {
			gold++;
		}
		if(inRange(x, y-k) && grid[x][y-k] == 1) {
			gold++;
		}
		if(inRange(x, y+k) && grid[x][y+k] == 1) {
			gold++;
		}
		
		return gold;
	}
	
	
	public static void calc(int k) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int goldCnt = calcGold(i,j,k);
				
				if(goldCnt * m >=  (k*k)+(k+1)*(k+1)) {
					maxCnt= Math.max(maxCnt, goldCnt);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int k=n; k>=0; k--) {
			calc(k);
		}
		
		System.out.println(maxCnt);
		sc.close();
	}
}