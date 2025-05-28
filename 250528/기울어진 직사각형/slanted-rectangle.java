import java.util.Scanner;

public class Main {
	public static int n;
	public static int[][] grid;
	
	public static int maxSum = 0;
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x< n && 0<= y && y<n;
	}
	
	public static int calc(int x, int y, int row, int col) {
		int sum = 0; //시작점
		
		int x1 = x;
		int y1 = y;
		
		int x2 = x-row+1;
		int y2 = y+row-1;
		
		int x3 = x-row-col+2;
		int y3= y+row-col;
		
		int x4 = x-col+1;
		int y4 = y-col+1;
		
		//1번방향, 3번방향 합 더하기
		for(int i=1; i<row; i++) {
			sum+=grid[x1-i][y1+i];
			sum+=grid[x3+i][y3-i];
		}
		
		//2번방향, 4번 방향 합 더하기
		for(int i=1; i<col; i++) {
			sum+=grid[x2-i][y2-i];
			sum+=grid[x4+i][y4+i];
		}
		return sum;
	}
	
	public static void calcSum(int x, int y) {
		
		for(int row = 2; row<n; row++) {
			for(int col = 2; col <n; col++) {
				if(inRange(x,y) && inRange(x-row+1,y+row-1) 
						&& inRange(x-row-col+2,y+row-col) && inRange(x-col+1,y-col+1)) {
					int sum = calc(x,y,row,col);
					maxSum = Math.max(maxSum, sum);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int [n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				calcSum(i,j);
			}
		}
		System.out.println(maxSum);
		
		sc.close();
	}
}