import java.util.Scanner;

public class Main {
	public static int n,m; //n:board 의 행 열의 개수, m: 연속하여 m개 이상의 동일한 원소가 나오는 개수를 체크할 용도
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		board[i][j] = sc.nextInt();
        	}
        }
        
        int happy = 0; //행복한 수열의 개수를 세기 위한 변수
        for(int i=0; i<n; i++) {      	
        	int maxSuccessive = 0;
        	int temp = 1;
        	for(int j=1; j<n; j++) {
        		if(board[i][j] == board[i][j-1]) {
        			temp++;
        		}
        		else {
        			maxSuccessive = Math.max(maxSuccessive, temp);
        			temp = 1;
        		}
        	}
        	maxSuccessive = Math.max(maxSuccessive, temp);
        	if(maxSuccessive >= m) {
        		happy++;
        	}
        }
        for(int i=0; i<n; i++) {      	
        	int maxSuccessive = 0;
        	int temp = 1;
        	for(int j=1; j<n; j++) {
        		if(board[j][i] == board[j-1][i]) {
        			temp++;
        		}
        		else {
        			maxSuccessive = Math.max(maxSuccessive, temp);
        			temp = 1;
        		}
        	}
        	maxSuccessive = Math.max(maxSuccessive, temp);
        	if(maxSuccessive >= m) {
        		happy++;
        	}
        }
        
        System.out.println(happy);
        
        sc.close();
    }
}