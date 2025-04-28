import java.util.Scanner;


public class Main {
	
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] board = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int maxCnt = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=0; j<n-2; j++) {
				int cnt = 0;
				for(int k=0; k<=2; k++) {
					for(int l=0; l<=2; l++) {
						if(board[i+k][j+l]== 1)
							cnt++;
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
		System.out.println(maxCnt);
		
		sc.close();
    }
}
