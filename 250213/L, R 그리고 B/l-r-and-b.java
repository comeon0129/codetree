import java.util.Scanner;

public class Main {
	
	public static char[][] board = new char[10][10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			String line = sc.next();
			board[i] = line.toCharArray();
		}
		
		int l_row = 0;
		int l_col = 0;
		int r_row = 0;
		int r_col = 0;
		int b_row = 0;
		int b_col = 0;
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(board[i][j] =='L') {
					l_row = i;
					l_col = j;
				}
				else if(board[i][j] =='R') {
					r_row = i;
					r_col = j;
				}
				else if(board[i][j] =='B') {
					b_row = i;
					b_col = j;
				}
			}
		}
		int ans = Math.abs(l_row - b_row) + Math.abs(l_col - b_col) -1; //마지막 도착지점은 제외 
		
		if(l_row == r_row && r_row == b_row && ((l_col < r_col && r_col < b_col)||(b_col < r_col && r_col < l_col)) ) // 가로로 일직선상에 있는 경우
			ans+=2;
		
		else if(l_col == r_col && r_col == b_col && ((l_row < r_row && r_row <b_row)||(b_row < r_row && r_row < l_row)) ){
			ans+=2;
		}
		
		System.out.println(ans);
		sc.close();
    }
}
