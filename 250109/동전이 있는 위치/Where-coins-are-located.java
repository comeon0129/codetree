import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	
    	int[][] arr2d = new int[n][n];
    	
    	int m = sc.nextInt();
    	
    	for(int i=0; i<m; i++) {
    		int r = sc.nextInt();
    		int c = sc.nextInt();
    		arr2d[r-1][c-1] = 1;
    	}
    	
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(arr2d[i][j]+" ");
    		}
    		System.out.println();
    	}
    	

        sc.close();
    }
}
