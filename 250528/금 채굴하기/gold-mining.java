import java.util.Scanner;

public class Main {
	public static int n; //격자 크기 
	public static int m; //금 한개의 가격
	public static int[][] grid;
	
	public static int maxCnt = 0; // 최대 채굴가능한 금의 개수
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x < n && 0<= y && y<n;
	}
	
	public static void calc(int k) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int cnt =0;
				
				for(int x=0; x<n; x++) {
					for(int y=0; y<n; y++) {
						if(Math.abs(x-i)+Math.abs(y-j) <= k) {
							if(grid[x][y] == 1)
								cnt++;
						}
					}
				}
				
				if(cnt * m >= k*k + (k+1) * (k+1)) {
					maxCnt = Math.max(maxCnt, cnt);
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
		
		for(int k=n-1; k>=0; k--) {
			calc(k);
		}
		
		System.out.println(maxCnt);
		sc.close();
	}
}