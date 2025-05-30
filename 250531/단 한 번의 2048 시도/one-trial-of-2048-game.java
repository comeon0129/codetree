import java.util.Scanner;


public class Main {
	public static int[][] grid= new int[4][4];
	public static char dir;
	
	public static void l_concat() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				if(grid[i][j] == grid[i][j+1]) {
					grid[i][j] = grid[i][j] *2;
					grid[i][j+1] = 0;
				}
			}
		}
		return;
	}
	
	public static void r_concat() {
		for(int i=0; i<4; i++) {
			for(int j=3; j>0; j--) {
				if(grid[i][j] == grid[i][j-1]) {
					grid[i][j] = grid[i][j] *2;
					grid[i][j-1] = 0;
				}
			}
		}
		return;
	}
	
	public static void u_concat() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				if(grid[i][j] == grid[i+1][j]) {
					grid[i][j] = grid[i][j] *2;
					grid[i+1][j] = 0;
				}
			}
		}
		return;
	}
	
	public static void d_concat() {
		for(int i=3; i>0; i--) {
			for(int j=0; j<4; j++) {
				if(grid[i][j] == grid[i-1][j]) {
					grid[i][j] = grid[i][j] *2;
					grid[i-1][j] = 0;
				}
			}
		}
		return;
	}
	
	public static void l_move() {
		int[][] temp = new int[4][4];
		for(int i=0; i<4; i++) {
			int tempIdx = 0;
			for(int j=0; j<4; j++){
				if(grid[i][j] != 0) {
					temp[i][tempIdx] = grid[i][j];
					tempIdx++;
				}
			}
		}
		grid = temp;
	}
	public static void r_move() {
		int[][] temp = new int[4][4];
		for(int i=0; i<4; i++) {
			int tempIdx = 3;
			for(int j=3; j>=0; j--){
				if(grid[i][j] != 0) {
					temp[i][tempIdx] = grid[i][j];
					tempIdx--;
				}
			}
		}
		grid = temp;
	}
	public static void u_move() {
		int[][] temp = new int[4][4];
		for(int i=0; i<4; i++) {
			int tempIdx = 0;
			for(int j=0; j<4; j++){
				if(grid[j][i] != 0) {
					temp[tempIdx][i] = grid[j][i];
					tempIdx++;
				}
			}
		}
		grid = temp;
	}
	public static void d_move() {
		int[][] temp = new int[4][4];
		for(int i=0; i<4; i++) {
			int tempIdx = 3;
			for(int j=3; j>=0; j--){
				if(grid[j][i] != 0) {
					temp[tempIdx][i] = grid[j][i];
					tempIdx--;
				}
			}
		}
		grid = temp;
	}


	//방향에 따라 실제 움직이게 해주는 함수
	public static void shift() {
		if(dir == 'L') {
			l_concat();
			l_move();
		}
		else if(dir =='R') {
			r_concat();
			r_move();
		}
			
		else if(dir=='U') {
			u_concat();
			u_move();
		}
			
		else if(dir == 'D') {
			d_concat();
			d_move();
		}	
	}
	
	//격자 상태 출력하는 함수
	public static void printGrid() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		dir = sc.next().charAt(0);
		
		shift();
		
		printGrid();
		
		sc.close();
	}
}
