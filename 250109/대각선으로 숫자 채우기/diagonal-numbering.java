import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	int[][]arr2d = new int[n][m];
    	int cnt = 1;
  
    	for(int i=0; i<n+m-1; i++) {
    		for(int y=0; y< n; y++) {
    			for(int x=0; x<m; x++) {
    				if(x+y == i) {
    					arr2d[y][x] = cnt;
    					cnt++;
    				}
    			}
    		}	
    	}
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			System.out.print(arr2d[i][j]+" ");
    		}
    		System.out.println();
    	}
    		
        sc.close();
    }
}
