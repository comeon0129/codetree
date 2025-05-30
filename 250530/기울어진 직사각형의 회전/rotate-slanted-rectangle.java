import java.util.Scanner;


public class Main {
	public static int n; //격자 크기
	public static int[][] grid;
	public static int r,c; // 시작 점 좌표
	public static int m1,m2,m3,m4; // 각각의 방향으로의 이동 횟수
	public static int dir; //회전 방향
	
	public static void clockWise(){
		int temp1= grid[r-m4][c-m4];
		int temp2 = grid[r-m4-m3][c-m4+m3];
		int temp3 = grid[r-m1][c+m1];
		
		//4번 방향으로 회전
		for(int i=m4; i>=1; i--) {
			grid[r-i][c-i] =grid[r-i+1][c-i+1];
		}
		//3번 방향으로 회전
		for(int i=m3; i>=1; i--) {
			grid[r-m4-i][c-m4+i] = grid[r-m4-i+1][c-m4+i-1];
		}
		//2번 방향으로 회전
		for(int i=m2; i>=1; i--) {
			grid[r-m4-m3+i][c-m4+m3+i] = grid[r-m4-m3+i-1][c-m4+m3+i-1];
		}
		//1번 방향으로 회전
		for(int i=m1; i>=1; i--) {
			grid[r-m1+i][c+m1-i] = grid[r-m1+i-1][c+m1-i+1];
		}
		
		grid[r-m4-1][c-m4+1] = temp1;
		grid[r-m4-m3+1][c-m4+m3+1]= temp2;
		grid[r-m1+1][c+m1-1] = temp3;
		
		return;
	}
	
	
	//반시계 방향으로 회전하는 함수
	public static void antiClockWise() {
		
		int temp1 = grid[r-m1][c+m1];
		int temp2 = grid[r-m1-m2][c+m1-m2];
		int temp3 = grid[r-m4][c-m4];
		
		//1번 방향으로 회전
		for(int i=m1; i>=1; i--) {
			grid[r-i][c+i] = grid[r-i+1][c+i-1];
		}
		//2번 방향으로 회전
		for(int i=m2; i>=1; i--) {
			grid[r-m1-i][c+m1-i] = grid[r-m1-i+1][c+m1-i+1];
		}
		//3번 방향으로 회전
		for(int i=m3; i>=1; i--) {
			grid[r-m1-m2+i][c+m1-m2-i] = grid[r-m1-m2+i-1][c+m1-m2-i+1];
		}
		//4번 방향으로 회전
		for(int i=m4; i>=1; i--) {
			grid[r-m4+i][c-m4+i] = grid[r-m4+i-1][c-m4+i-1];
		}
		
		grid[r-m1-1][c+m1-1] = temp1;
		grid[r-m1-m2+1][c+m1-m2-1] = temp2;
		grid[r-m4+1][c-m4+1] = temp3;
		
		return;
	}
	
	public static void printGrid() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		r = sc.nextInt();
		c = sc.nextInt();
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		dir = sc.nextInt();
		
		if(dir == 0)
			antiClockWise();
		else if(dir == 1)
			clockWise();
		
		printGrid();
		
		sc.close();
	}
}
