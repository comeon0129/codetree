import java.util.Scanner;


public class Main {
	
	public static int n,m,k; // n: 격자의 크기 m: 떨어지는 블록의 크기 k: 블록이 떨어질 열에 대한 정보
	
	public static void simulate(int[][]board) {
		
		for(int i=0; i<n; i++) { // 행이 바뀌어가는 것임
			for(int j=k-1; j<k-1+m; j++) {
				if(board[i][j] == 1) {
					for(int l =k-1; l<k-1+m; l++) {
						board[i-1][l] = 1;
					}
					return;
				}
			}
		}
		
		//이 for문을 다 돌동안 return 되지 못한 경우 마지막 줄에 블럭이 놓임
		for(int i=k-1; i<k-1+m; i++) {
			board[n-1][i] = 1;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
	    m = sc.nextInt();
	    k = sc.nextInt();
	    
	    int[][] board = new int[n][n];
	    
	    for(int i=0; i<n; i++) {
	    	for(int j=0; j<n; j++) {
	    		board[i][j] = sc.nextInt();
	    	}
	    }
	    
	    simulate(board);
	    
	    for(int i=0; i<n; i++) {
	    	for(int j=0; j<n; j++) {
	    		System.out.print(board[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	
	
		sc.close();
	}
}

