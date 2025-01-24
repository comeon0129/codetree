import java.util.Scanner;


public class Main {
	
	public static int[][] board = new int [20][20];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int x_pos = 0;
		int y_pos = 0;
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		//가로로 검사하는 경우
		for(int i=1; i<=19; i++) {
			for(int j=1; j<=15; j++) {
				if(board[i][j]== 1 && board[i][j+1]==1 && board[i][j+2]==1 && board[i][j+3]==1 && board[i][j+4]==1) {
					ans =1;
					x_pos = i;
					y_pos = j+2;
				}
				else if(board[i][j]== 2 && board[i][j+1]== 2 && board[i][j+2]==2 && board[i][j+3]==2 && board[i][j+4]==2) {
					ans =2;
					x_pos = i;
					y_pos = j+2;
				}
			}
		}
		//여전히 승부가 결정나지 않은 경우
		if(ans == 0) {
			//세로로 검사하는 경우
			for(int i=1; i<=15; i++) {
				for(int j=1; j<=19; j++) {
					if(board[i][j]== 1 && board[i+1][j]==1 && board[i+2][j]==1 && board[i+3][j]==1 && board[i+4][j]==1) {
						ans =1;
						x_pos = i+2;
						y_pos = j;
					}
					else if(board[i][j]== 2 && board[i+1][j]== 2 && board[i+2][j]==2 && board[i+3][j]==2 && board[i+4][j]==2) {
						ans =2;
						x_pos = i+2;
						y_pos = j;
					}
				}
			}
			//가로 세로 검사에도 여전히 승부가 나지 않은 경우
			if(ans == 0) {
				// 우상향 대각선 검사
				for(int i=5; i<=19; i++) {
					for(int j=1; j<=15; j++) {
							if(board[i][j]==1 && board[i-1][j+1]==1 && board[i-2][j+2] ==1 && board[i-3][j+3]==1 && board[i-4][j+4]==1) {
								ans = 1;
								x_pos = i-2;
								y_pos = j+2;
							}
							else if(board[i][j]==2 && board[i-1][j+1]==2 && board[i-2][j+2] ==2 && board[i-3][j+3]==2 && board[i-4][j+4]==2) {
								ans = 2;
								x_pos = i-2;
								y_pos = j+2;
							}
					}
				}
				
				if(ans == 0) {
					//우하향 대각선 검사
					for(int i=1; i<=15; i++) {
						for(int j=5; j<=19; j++) {
							if(board[i][j-4]==1 && board[i+1][j-3]==1 && board[i+2][j-2]==1 && board[i+3][j-1]==1 && board[i+4][j]==1) {
								ans =1;
								x_pos = i+2;
								y_pos = j-2;
							}
							else if(board[i][j-4]==2 && board[i+1][j-3]==2 && board[i+2][j-2]==2 && board[i+3][j-1]==2 && board[i+4][j]==2) {
								ans =2;
								x_pos = i+2;
								y_pos = j-2;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
		if(ans !=0) {
			System.out.println(x_pos+" "+y_pos);
		}
		
		sc.close();
    }
}