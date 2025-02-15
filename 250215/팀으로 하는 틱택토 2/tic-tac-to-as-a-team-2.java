import java.util.Scanner;

public class Main {
	
	public static char[][] board = new char[3][3];
	
	public static boolean isWin (int a, int b) {
		
		//가로 검사
		for(int i=0; i<3; i++) {
			boolean flag = true;
			int rowSum  = 0;
			for(int j=0; j<3; j++) {
				if(board[i][j] -'0' != a && board[i][j]-'0' !=b) {
					flag = false;
					break;
				}
				rowSum += board[i][j] -'0';
			}
			if(flag && (rowSum == (2*a+b) || rowSum == (a+2*b)))
				return true;
		}
		//세로 검사
		for(int i=0; i<3; i++) {
			boolean flag = true;
			int colSum  = 0;
			for(int j=0; j<3; j++) {
				if(board[j][i] -'0' != a && board[j][i]-'0' !=b) {
					flag = false;
					break;
				}
				colSum += board[j][i] -'0';
			}
			if(flag && (colSum == (2*a+b) || colSum == (a+2*b)))
				return true;
		}
		
		//대각선 검사
				
		int diagSum1 = 0;
		int diagSum2 = 0;
		
		boolean flag1 = true;
		boolean flag2 = true;
		for(int i=0; i<3; i++) {
			if(board[i][i] -'0' != a && board[i][i]-'0' !=b) {
				flag1= false;
				break;
			}
			diagSum1 += board[i][i] -'0';	
		}
		
		
		for(int i=0; i<3; i++) {
			if(board[i][2-i] -'0' != a && board[i][2-i]-'0' !=b) {
				flag2= false;
				break;
			}
			diagSum2 += board[i][2-i] -'0';	
		}
		
		if(flag1 &&(diagSum1 == (2*a+b) || diagSum1 ==(a+2*b)))
			return true;
		if(flag2 && (diagSum2 == (2*a+b) || diagSum2 ==(a+2*b)))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			String s = sc.next();
			board[i] = s.toCharArray();
		}
		
		int cnt = 0;
		//틱태토는 최대 8번만 검사를 하면 승리할 수 있는지를 검사할 수 있음.
		for(int i=1; i<=9; i++) {
			for(int j=i+1; j<=9; j++) {
				if(isWin(i,j)) {
					cnt++;
				}
					
			}
		}
		System.out.println(cnt);
		sc.close();
    }
}