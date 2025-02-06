import java.util.Scanner;

public class Main {
	public static final int MAX_N = 20;
	public static int[][] board = new int[MAX_N][MAX_N];
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-2; j++) {
				for(int k=0; k<n; k++) {
					for(int l=0; l<n-2; l++) {
						if(i == k && l <= j+2) { // 두 격자가 같은 행에 있는데 겹치는 경우
							continue;
						}
						ans = Math.max(ans, board[i][j]+board[i][j+1]+board[i][j+2]+board[k][l]+board[k][l+1]+board[k][l+2]);
					}
				}
			}
		}
		System.out.println(ans);
		
		
		sc.close();
    }
}