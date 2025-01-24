import java.util.Scanner;


public class Main {
	
	public static int n,m;
	
	public static final int MAX_ROTATE = 8;
	
	public static char[][]board = new char[50][50];
	// 왼쪽 아래, 아래쪽, 오른쪽 아래, 왼쪽 위, 위, 오른쪽 위, 왼쪽, 오른쪽 순으로 정렬
	public static int[] dx = new int[] {1,1,1,-1,-1,-1,0,0};
	public static int[] dy = new int[] {-1,0,1,-1,0,1,-1,1};
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		int ans = 0;
		for(int i=0; i<n; i++) {
			String line = sc.nextLine();
			board[i] = line.toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 'L') {
					for(int k=0; k<MAX_ROTATE; k++) {
						int curcnt = 1;
						int curx = i;
						int cury = j;
						while(true) {
							int nx=curx+dx[k];
							int ny=cury+dy[k];
							if(inRange(nx, ny)==false) {
								break;
							}
							if(board[nx][ny] != 'E') {
								break;
							}
							curcnt++;
							curx = nx;
							cury = ny;
							if(curcnt == 3) {
								ans++;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}
