import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n,m;
	public static char[][] answer = new char[MAX_N+1][MAX_N+1];
	
	public static int[] dx = new int[] {0,1,0,-1}; // 오른쪽,아래,왼쪽,위 순서
	public static int[] dy = new int[] {1,0,-1,0}; // 오른쪽,아래,왼쪽,위 순서
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<= n && 1<=y && y<=m;
	}
	
	public static char[] alpha = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x = 1;
		int y = 1;
		answer[x][y] = 'A';
		int dirNum =0;
		for(int i=0; i<n*m-1; i++) {
			int alpha_idx = (i+1) % 26;
			int nx = x+dx[dirNum];
			int ny = y+dy[dirNum];
			if(!inRange(nx,ny) || answer[nx][ny] !=0) {
				dirNum = (dirNum+1) % 4;
			}
			x = x+dx[dirNum];
			y = y+dy[dirNum];
			answer[x][y] = alpha[alpha_idx];
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
    }
}
