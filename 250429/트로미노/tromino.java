import java.util.Scanner;

public class Main {
	public static int n,m; //n:board 의 행 열의 개수, m: 연속하여 m개 이상의 동일한 원소가 나오는 개수를 체크할 용도
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        int[][] board = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		board[i][j] = sc.nextInt();
        	}
        }
        
        int maxSum = 0;
        
        for(int i=0; i<n; i++) { // 1by3 블럭으로 brute-force
        	for(int j=0; j<m; j++) {
        		
        		int rowSum = 0;
        		int columnSum = 0;
        		for(int k=0; k<3; k++) {
        			if(j+k < m)
        			rowSum += board[i][j+k];
        			
        			if(i+k < n)
        			columnSum += board[i+k][j];
        		}
        		maxSum = Math.max(maxSum, rowSum);
        		maxSum = Math.max(maxSum, columnSum);
        	}
        }
        
        for(int i=0; i<n; i++) { // 꺾인 블록으로 합을 세는 경우
        	for(int j=0; j<m; j++) {
        		
        		if(i-1>=0 && j+1 < m)
        			maxSum = Math.max(maxSum, board[i-1][j]+board[i][j]+board[i][j+1]);
        		
        		if(i-1>=0 && j-1 >=0)
        			maxSum = Math.max(maxSum, board[i][j-1]+board[i][j]+board[i-1][j]);
        		
        		if(j-1>=0 && i+1 < n)
        			maxSum = Math.max(maxSum, board[i][j-1]+board[i][j]+board[i+1][j]);
        		
        		if(j+1 < m && i+1 < n)
        			maxSum = Math.max(maxSum, board[i][j+1]+board[i][j]+board[i+1][j]);
        		
        	}
        }
       
        System.out.println(maxSum);
        
        sc.close();
    }
}
