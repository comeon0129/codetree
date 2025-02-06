import java.util.Scanner;

public class Main {
	public static final int MAX_N =99;
	public static int n,t;
	public static int[][] board = new int[MAX_N][MAX_N];
	
	public static int[] dx = new int[] {-1,0,1,0}; //북,동,남,서 순서
	public static int[] dy = new int[] {0,1,0,-1};
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x < n && 0<=y && y<n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		String command = sc.next();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int x = n/2;
		int y = n/2;
		int dirNum =0;
		int total = board[x][y];
		for(int i=0; i<t; i++) {
			if(command.charAt(i) == 'L') {
				dirNum = (dirNum-1+4) % 4;
			}
			else if(command.charAt(i) == 'R') {
				dirNum = (dirNum+1) % 4;
			}
			else {
				int nx = x+dx[dirNum];
				int ny = y+dy[dirNum];
				if(inRange(nx,ny)) {
					x=x+dx[dirNum];
					y=y+dy[dirNum];
					total+=board[x][y];
				}
			}
		}
		System.out.println(total);
		
		sc.close();
    }
}
