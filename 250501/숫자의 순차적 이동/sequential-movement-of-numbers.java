import java.util.Scanner;


public class Main {
	
	public static int n,m;
	
	public static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static void findMaxNeighbor(int curX, int curY, int[][] board) {
		int[] dx = {0,1,1,1,0,-1,-1,-1}; //도는 순서는 동,남동,남,남서,서,북서,북,북동 순서
		int[] dy = {1,1,0,-1,-1,-1,0,1};
		
		int maxNum = 0;
		int maxX = -1, maxY = -1;
		
		for(int i=0; i<8; i++) {
			int nextX = curX+dx[i];
			int nextY = curY+dy[i];
			
			if(inRange(nextX, nextY)&&
					board[nextX][nextY] > maxNum) {
				maxNum = board[nextX][nextY];
				maxX = nextX;
				maxY = nextY;
			}	
		}
		int temp = board[curX][curY];
		board[curX][curY] = board[maxX][maxY];
		board[maxX][maxY] = temp;
		
		
	}
	
	public static void displayBoard(int[][] board) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		while(m-->0) {
			int curNum = 1;
			while(curNum <= n * n) {
				boolean isExchanged = false;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(!isExchanged && board[i][j] == curNum) {
							findMaxNeighbor(i, j, board);
							isExchanged = true;
						}
					}
				}
				curNum++;
			}
		}
		
		displayBoard(board);
		
		
		sc.close();
	}
}

