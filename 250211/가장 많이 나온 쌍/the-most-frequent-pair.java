import java.util.Scanner;

public class Main {
	
	public static int n,m;
	
	public static int[][] board = new int[11][11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			board[a][b] ++; 
		}
		int maxCnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				int cnt =0;
				cnt = board[i][j] + board[j][i];
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		
		System.out.println(maxCnt);
		
		
		sc.close();
    }
}