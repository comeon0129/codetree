import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[][] answer = new int[100][100];
	
	
	public static boolean inRange (int x, int y) {
		return (0 <= x && x < n && 0 <= y && y <m); 
	}

	// x는 행이고 y는 열이라고 생각할것.
	public static int[] dx = new int[] {0,1,0,-1};  //순서가 오른쪽, 아래, 왼쪽, 위
	public static int[] dy = new int[] {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x =0 , y = 0;
		int dirNum = 0;
		answer[x][y] = 1;
		for(int i=2; i<=n*m; i++) {
			int nx = x+ dx[dirNum] , ny = y+dy[dirNum];
			
			if(!inRange(nx,ny) || answer[nx][ny] != 0) {
				dirNum = (dirNum + 1) % 4;
			}
			x = x + dx[dirNum]; y = y+ dy[dirNum];
			answer[x][y] = i;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
    }
}
