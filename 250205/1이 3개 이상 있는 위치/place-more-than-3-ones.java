import java.util.Scanner;


public class Main {
	
	public static int n;
	
	public static int[][] board = new int[100][100];
	
	
	public static boolean inRange (int x, int y) {
		return (0 <= x && x < n && 0 <= y && y <n); 
	}

	
	// x는 행이고 y는 열이라고 생각할것.
	public static int[] dx = new int[] {0,1,0,-1};  //순서가 오른쪽, 아래, 왼쪽, 위
	public static int[] dy = new int[] {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		for(int x=0; x<n; x++) {
			for(int y = 0; y<n; y++) {
				int cnt =0;
				for(int dirNum = 0; dirNum < 4; dirNum ++) {
					int nx = x + dx[dirNum] , ny = y + dy[dirNum];
					if(inRange(nx,ny) && board[nx][ny] == 1) {
						cnt ++;
					}
				}
				if(cnt>=3) {
					ans++;
				}
			}
		}
		System.out.println(ans);
		sc.close();
    }
}