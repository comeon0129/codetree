import java.util.Scanner;

public class Main {
	
	public static int k,n; // k: 경기 수, n: 개발자 수
	
	public static int[][] board = new int[10][21];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				int rank = sc.nextInt();
				board[i][rank] = j+1;
			}
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j)
					continue;
				int cnt = 0;
				for(int l = 0; l<k; l++) {
					if(board[l][i] < board[l][j]) {
						cnt++;
					}
				}
				if(cnt == k) { // 모든 경기에서 우선순위가 더 높은 경우
					ans++;
				}
				
			}
		}
		System.out.println(ans);
		
		sc.close();
    }
}