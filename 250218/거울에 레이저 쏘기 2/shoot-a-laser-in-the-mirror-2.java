import java.util.Scanner;

public class Main {
	
	public static int n,k;
	
	public static char[][] board = new char[1001][1001];
	
	public static boolean inRange(int x, int y) {
		return x>=0 && x< n && y>=0 && y<n;
	}
	
	public static int[] dx = new int[]{0,0,-1,1}; // 좌, 우, 위, 아래 순서
	public static int[] dy = new int[]{-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			String s = sc.next();
			board[i] = s.toCharArray();
		}
		k = sc.nextInt();
		
		int x =0;
		int y =0;
		int dirNum = 0;
		if(k>=1 && k<=n) { 
			x = 0; 
			y = k-1;
			dirNum = 3;
		}
		else if(k>n && k<=2*n) { //k-n행 n열에서 시작
			x = k-n-1;
			y = n-1;
			dirNum = 0;
		}
		else if(k>2*n && k<=3*n) { 
			x = n-1;
			y = 3*n - k;
			dirNum = 2;
		}
		else {
			x = 4*n - k;
			y = 0;
			dirNum = 1;
		}
		
		int cnt = 0;
		
		while(inRange(x,y)) {
		
			if(board[x][y] == '/') {
				if(dirNum == 0)
					dirNum = 3;
				else if(dirNum == 1)
					dirNum = 2;
				else if(dirNum == 2)
					dirNum = 1;
				else
					dirNum = 0;
			}
			else if(board[x][y] == '\\') {
				if(dirNum == 0)
					dirNum = 2;
				else if(dirNum == 1)
					dirNum = 3;
				else if(dirNum == 2)
					dirNum = 0;
				else
					dirNum = 1;
			}
			
			x= x+dx[dirNum];
			y= y+dy[dirNum];
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
    }
}