import java.util.Scanner;

public class Main {

	public static int n;//격자 크기
	public static int m;//주사위 굴릴 횟수
	public static int r,c; //주사위 초기 위치
	public static int[][] grid;
	public static int[] dice; //순서대로 top, mid, right 순서
	
	public static int[] dx = {0,0,-1,1}; //좌,우,위,아래 순서
	public static int[] dy = {-1,1,0,0};
	
	
	public static void changeDice(char dir) {
		int[] temp = new int[3];
		for(int i=0; i<3; i++) {
			temp[i] = dice[i];
		}
		
		if(dir== 'L') {
			dice[0] = temp[2]; // top = right;
			dice[2] = 7-temp[0]; // right = bottom;
		}
		
		else if(dir == 'R') {
			dice[0] = 7-temp[2]; //top = left;
			dice[2] = temp[0]; //right = top;
		}
		
		else if(dir == 'U') {
			dice[0] = temp[1]; // top = mid;
			dice[1] = 7-temp[0]; // mid = bottom
		}
		
		else if(dir == 'D') {
			dice[0] = 7-temp[1]; // top = back;
			dice[1] = temp[0]; // mid = top;
		}
	
	}
	
	public static boolean inRange(int x, int y) {
		return 1<=x && x<=n && 1<=y && y<=n;
	}
	
	public static int calcSum() {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(grid[i][j] != 0)
					sum+=grid[i][j];
			}
		}
		return sum;
	}
	
	public static boolean canRoll(int dirNum) {
		int nr = r + dx[dirNum];
		int nc = c+ dy[dirNum];
		
		if(inRange(nr,nc))
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		grid = new int[n+1][n+1];
		dice = new int[3];
		//초기 상태 지정하기
		grid[r][c] = 6; //초기 상태값 찍기
		
		for(int i =0; i<3; i++) {
			dice[i] = i+1;
		}
		
		int dirNum = -1; //초기 방향
		
		while(m-->0) {
			char dir = sc.next().charAt(0);	
			
			if(dir == 'L')
				dirNum = 0;
			else if(dir == 'R')
				dirNum = 1;
			else if(dir == 'U')
				dirNum = 2;
			else if(dir == 'D')
				dirNum = 3;

			//주사위를 굴릴 수 있는 경우에만 수행
			if(canRoll(dirNum)) {
				
				//실제 굴려서 좌표 이동
				r = r+dx[dirNum]; 
				c = c+dy[dirNum];
				
				changeDice(dir); //주사위 상태 변화시켜주고
				
				grid[r][c] = 7- dice[0]; //밑면 찍기  
				
			}
			
		}
		
		int sum = calcSum();
		System.out.println(sum);
		sc.close();
	}
}