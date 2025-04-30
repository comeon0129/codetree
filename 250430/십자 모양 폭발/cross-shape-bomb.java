import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        int range = grid[r][c];
        
        grid[r][c] = 0; //터지는 곳 전부 0으로 변환
        for(int i=1; i<range; i++) {
        	if(c-i>=1) //격자를 벗어나지 않는 경우
        		grid[r][c-i] = 0;
        	if(c+i<=n)
        		grid[r][c+i] = 0;
        	if(r-i>=1)
        		grid[r-i][c] = 0;
        	if(r+i<=n)
        		grid[r+i][c] = 0;
        }
        
        
        int[][] temp =  new int[n+1][n+1];
        for(int j=1; j<=n; j++) {
        	int tempIdx = n;
        	for(int i=n; i>=1; i--) {
        		if(grid[i][j]!=0) {
        			temp[tempIdx][j] = grid[i][j];
        			tempIdx--;
        		}
        	}
        }
        grid = temp;
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		System.out.print(grid[i][j]+" ");
        	}
        	System.out.println();
        }
        
        
        sc.close();
    }
}