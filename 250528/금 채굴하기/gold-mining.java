import java.util.Scanner;

public class Main {
	public static int n; //격자 크기 
	public static int m; //금 한개의 가격
	public static int[][] grid;
	public static int[][] used;
	
	public static int tempCnt = 0;
	public static int maxCnt = 0; // 최대 채굴가능한 금의 개수
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x < n && 0<= y && y<n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(used[x][y] == 1)
			return false;
		return true;
	}
	
	public static void calcGold(int x, int y, int k, int cnt) {
		if(cnt > k)
			return ;
		
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		used[x][y] = 1;
		
		if(grid[x][y] == 1)
			tempCnt++;
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX, newY)) {
				calcGold(newX,newY,k,cnt+1);
			}
		}
		
		return ;
	}
	
	
	public static void calc(int k) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tempCnt = 0;					// 임시로 골드 개수 셀 변수 초기화
				calcGold(i,j,k,0);			    // 일시적인 골드 개수 세기
				used = new int[n][n];		// used 초기화
				
				if(tempCnt * m >=  (k*k)+(k+1)*(k+1)) {
					maxCnt= Math.max(maxCnt, tempCnt);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		used = new int[n][n];
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
import java.util.Scanner;

public class Main {
	public static int n; //격자 크기 
	public static int m; //금 한개의 가격
	public static int[][] grid;
	public static int[][] used;
	
	public static int tempCnt = 0;
	public static int maxCnt = 0; // 최대 채굴가능한 금의 개수
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x < n && 0<= y && y<n;
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false;
		if(used[x][y] == 1)
			return false;
		return true;
	}
	
	public static void calcGold(int x, int y, int k, int cnt) {
		if(cnt > k)
			return ;
		
		int[] dx = {-1,1,0,0}; //상하좌우 순서
		int[] dy = {0,0,-1,1};
		
		used[x][y] = 1;
		
		if(grid[x][y] == 1)
			tempCnt++;
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			
			if(canGo(newX, newY)) {
				calcGold(newX,newY,k,cnt+1);
			}
		}
		
		return ;
	}
	
	
	public static void calc(int k) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tempCnt = 0;					// 임시로 골드 개수 셀 변수 초기화
				calcGold(i,j,k,0);			    // 일시적인 골드 개수 세기
				used = new int[n][n];		// used 초기화
				
				if(tempCnt * m >=  (k*k)+(k+1)*(k+1)) {
					maxCnt= Math.max(maxCnt, tempCnt);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		used = new int[n][n];
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
