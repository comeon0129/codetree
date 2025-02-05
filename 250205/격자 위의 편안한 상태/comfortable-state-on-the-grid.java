import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	public static int n,m;
	public static int r,c;
	public static int[][] board = new int[MAX_N+1][MAX_N+1];
	
	//흔히 아는 x,y가 아닌 행, 열이라는 것을 기억하기!
	public static int[] dx = new int[] {0,1,0,-1};   // 순서대로 오른쪽, 아래, 왼쪽, 위 순
	public static int[] dy = new int[] {1,0,-1,0};
	
	public static boolean inRange (int x , int y) {
		return 1<= x && x <= n && 1<=y && y<= n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[] answer = new int[m];
		for(int i=0; i<m; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			board[r][c] = 1;
			int cnt = 0;
			for(int j=0; j<4; j++) {
				int nr = r +dx[j];
				int nc = c +dy[j];
				if(inRange(nr, nc) && board[nr][nc] == 1) {
					cnt++;
				}
			}
			if(cnt == 3) {
				answer[i] = 1;
			}
			else {
				answer[i] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			System.out.println(answer[i]);
		}
		
		sc.close();
    }
}